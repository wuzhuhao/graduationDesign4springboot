<style lang="postcss" scoped>
.home-container {}
</style>
<template>
    <section class="home-container">
    
        <MasterPage title="首页">
    
            <div slot="title-icon">
    
                <Icon type="ios-game-controller-b" />
    
            </div>
    
    
    
            <!-- 条件搜索 -->
    
            <div slot="searchContent" class="search-content-slot">
    
                <Form :model="formItem" :label-width="80">
    
                    <Row>
    
                       
    
                        <Col span="8">
    
                        <FormItem label="课题名称">
    
                            <Input v-model="formItem.subName" placeholder="请输入课题名称"></Input>
    
                        </FormItem>
    
                        </Col>
    
                        <Col span="8">
    
                        <FormItem label="课题状态">
    
                            <Select v-model="formItem.subStuState">
    
                            <Option v-for="(item,index) in subStuStateList" :value="index"  >{{item}} </Option>
    
                        </Select>
    
                        </FormItem>
    
                        </Col>
    
    
    
                    </Row>
    
                </Form>
    
            </div>
    
            <div slot="search">
    
    
    
                <Button type="info" icon="ios-search" style="float:left;margin:0 8px" @click="doSearch">查询</Button> &nbsp; &nbsp; &nbsp; &nbsp;
    
                <Button type="info" icon="ios-search" style="float:left;margin:0 8px" @click="ruler">分配选题</Button> &nbsp;
    
                <Button type="info" icon="ios-search" style="float:left;margin:0 8px" @click="toExamine(1)">通过审核</Button> &nbsp;
    
                <Button type="info" icon="ios-search" style="float:left;margin:0 8px" @click="toExamine(0)">拒绝审核</Button> &nbsp;
    
            </div>
    
            <div slot="paddingContent">
    
                <Table border  :columns="columns2" :data="tableData" @on-selection-change="changeSelect" ref="table"></Table>
    
            </div>
    
            <div slot="pager">
    
                <Page :total="this.pagination.total" :page-size="this.pagination.pageSize" :page-size-opts="this.pagination.pageSizeOpts" :current="this.pagination.currentPage" @on-change="pageChange" @on-page-size-change="pageSizeChange" show-elevator show-total show-sizer
    
                />
    
            </div>
    
    
    
        </MasterPage>
    
    
    
    
    
        <Modal v-model="modal12" closable footer-hide @on-ok='add' :styles="{top: '8%'}" :width='1000'>
    
            <MasterPage title="分配选题">
    
                <div slot="title-icon">
    
                    <Icon type="ios-game-controller-b" />
    
                </div>
    
    
    
                <!-- 条件搜索 -->
    
                <div slot="searchContent" class="search-content-slot">
    
                    <Form :model="formItem" :label-width="80">
    
                        <Row>
    
                            <Col span="8">
    
                            <FormItem label="学号：">
    
                                <Input v-model="studentFormItem.stuId" placeholder="请输入学号"></Input>
    
                            </FormItem>
    
                            </Col>
    
                            <Col span="8">
    
                            <FormItem label="姓名：">
    
                                <Input v-model="studentFormItem.stuName" placeholder="请输入姓名"></Input>
    
                            </FormItem>
    
                            </Col>
    
    
    
    
    
                        </Row>
    
                    </Form>
    
                </div>
    
                <div slot="search">
    
    
    
                    <Button type="info" icon="ios-search" style="float:left;margin:0 8px" @click="doSearch">查询</Button> &nbsp; &nbsp; &nbsp; &nbsp;
    
                    <Button type="info" icon="ios-search" style="float:left;margin:0 8px" @click="doReset">重置</Button> &nbsp;
    
    
    
                </div>
    
                <div slot="paddingContent">
    
                    <Table border  :columns="columns" :data="tableData1" @on-selection-change="changeSelect" ref="table"></Table>
    
                </div>
    
    
    
            </MasterPage>
    
        </Modal>
    
    
    
    </section>
</template>
<script>
import MasterPage from '@/components/Master'

export default {
    components: {
        MasterPage
    },
    data() {

        return {
            modal12: false,
            dialogStatus: '', //title自定义标题
            value3: false,
            styles: {
                height: 'calc(100% - 55px)',
                overflow: 'auto',
                paddingBottom: '53px',
                position: 'static'
            },
            studentFormItem: {
                stuId: '',
                stuPassword: '',
                stuName: '',
                stuMajor: '',
                stuClass: '',
                stuSex: '',
                stuAge: '',
                stuBirthday: '',
                stuPhone: '',
                stuMail: '',
                stuAddress: '',
                stuRemarks: '',
                academyId: '',
                //   academy:  '',
            },
            formData: {
                subId: '',
                subName: '',
                subNature: '',
                subSource: '',
                subTeaId: '',
                subFile: '',
                firstReportDeadline: '',
                lastReportDeadline: '',
                stuId: '',
                subStuState: '',
                subLastScore: '',
                showId: '',
                subIntroduce: '',
                student: '',
                teacher: '',
            },

            pagination: {
                pageSize: 10,
                page: 1,
                total: 0,
                pageSizeOpts: [5, 10, 15, 20, 25, 30],
                currentPage: 1
            },
            selectList: [], // 多选数据
            selectCount: 0, // 多选计数
            tableData: [],
            tableData1: [],
            formItem: {
                subId: '',
                subName: '',
                subNature: '',
                subSource: '',
                subTeaId: '',
                subFile: '',
                firstReportDeadline: '',
                lastReportDeadline: '',
                stuId: '',
                subStuState: '',
                subLastScore: '',
                showId: '',
                subIntroduce: '',
            },
            columns: [
               {
                    title: '学号',
                    key: 'stuId',
                    minWidth: 100,
                },{
                    title: '姓名',
                    key: 'stuName',
                    minWidth: 100,
                },
                
                {
                    title: '班级',
                    key: 'stuClass',
                    minWidth: 100,
                },
                {
                    title: '操作',
                    key: 'action',
                    width: 120,
                  

                    render: (h, params) => {
                        return h('div', [
                            h('Button', {
                                props: {
                                    type: 'primary',
                                    size: 'small',
                                },
                                attrs: {
                                    title: '分配'
                                },
                                on: {
                                    click: () => {
                                        this.distribution(params.row) //编辑方法
                                    }
                                }
                            }, '分配')
                        ]);
                    }
                }
            ],
            columns2: [{
                    type: 'selection',
                    width: 80,
                    align: 'center',
                    fixed: 'left',
                    minWidth: 100,
                },
                {
                    title: '序号',
                    type: 'index',
                    sortable: true,
                    minWidth: 100,
                    width: 100,
                    fixed: 'left',
                    align: 'center'
                },
                {
                    title: '课题名称',
                    key: 'subName',
                    minWidth: 150,
                    sortable: true
                },
                {
                    title: '指导教师',
                    key: 'teaName',
                    minWidth: 120,
                    width: 200,
                    sortable: true
                },
                {
                    title: '学生',
                    key: 'stuName',
                    minWidth: 120,
                    width: 200,
                    sortable: true
                },
                {
                    title: '专业',
                    key: 'stuClass',
                    minWidth: 120,
                    width: 200,
                    sortable: true
                },
                {
                    title: '审核结果',
                    key: 'subStuState',
                    minWidth: 100,
                    width: 200,
                    sortable: true
                }, {
                    title: '操作',
                    key: 'action',
                    fixed: 'right',
                    minWidth: 100,
                    width: 100,
                    align: 'center',
                    render: (h, params) => {
                        return h('div', [

                            h('Button', {
                                props: {
                                    type: 'primary',
                                    size: 'small',
                                },
                                attrs: {
                                    title: '查看'
                                },
                                on: {
                                    click: () => {
                                        this.edit(params.row) //编辑方法
                                    }
                                }
                            }, '查看')
                        ]);
                    }
                }
            ]
        }
    },

    created() {
        this.getData(1, 10);
        this.getStudent(1, 10);
    },
    methods: {
        exportData(type) {
            if (type === 1) {
                this.$refs.table.exportCsv({
                    filename: 'The original data'
                });
            } else if (type === 2) {
                this.$refs.table.exportCsv({
                    filename: 'Sorting and filtering data',
                    original: false
                });
            } else if (type === 3) {
                this.$refs.table.exportCsv({
                    filename: 'Custom data',
                    columns: this.columns8.filter((col, index) => index < 4),
                    data: this.data7.filter((data, index) => index < 4)
                });
            }
        },

        // watch: {
        //   // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
        //     '$route': 'getParams'
        // },
        //编辑
        edit(row) {
            this.dialogStatus = '编辑'; //对应标题
            this.formData.subId = row.subId
            this.formData.subName = row.subName
            this.formData.subNature = row.subNature
            this.formData.subSource = row.subSource
            this.formData.subTeaId = row.subTeaId
            this.formData.subFile = row.subFile
            this.formData.firstReportDeadline = row.firstReportDeadline
            this.formData.lastReportDeadline = row.lastReportDeadline
            this.formData.stuId = row.stuId
            this.formData.subStuState = row.subStuState
            this.formData.subLastScore = row.subLastScore
            this.formData.showId = row.showId
            this.formData.subIntroduce = row.subIntroduce
            this.formData.subNature = row.subNature
            this.formData.subSource = row.subSource
            this.value3 = true
        },
        delById(row) {
            this.$Modal.confirm({
                title: "确认删除",
                content: "您确认要删除?",
                onOk: () => {
                    console.log(row)
                    this.$axios({
                        url: 'sub/delete/' + row.subId,
                        method: 'get', //请求的方式
                        data: this.$Qs.stringify(this.formData),
                        // token:localStorage.getItem('token')
                    }).then(res => {
                        console.log(res.data)
                        this.getData(1, 10);
                    }).catch(err => {
                        console.info('报错的信息', err);

                    });
                }
            });

        },
        update() {
            console.log(this.formData)
            if (this.dialogStatus == '新增') {
                this.$axios({
                    url: 'sub/add',
                    method: 'post', //请求的方式
                    data: this.$Qs.stringify(this.formData),
                    // token:localStorage.getItem('token')
                }).then(res => {
                    console.log(res.data)
                    this.getData(1, 10)
                }).catch(err => {
                    console.info('报错的信息', err);

                });
                this.value3 = false
            } else if (this.dialogStatus == '编辑') {
                this.$axios({
                    url: 'sub/update',
                    method: 'post', //请求的方式
                    data: this.$Qs.stringify(this.formData),
                    // token:localStorage.getItem('token')
                }).then(res => {
                    console.log(res.data)
                    this.getData(1, 10)
                }).catch(err => {
                    console.info('报错的信息', err);

                });
                this.value3 = false
            }

        },
        getData(page, pageSize) {
            let token = localStorage.getItem('token')
            let userId = localStorage.getItem('userId')
            this.formItem.subTeaId = userId
            let params = this.formItem
            this.$axios({

                url: 'sub/listOfTea?page=' + page + '&pageSize=' + pageSize,
                method: 'get', //请求的方式
                params: params,
                // token:localStorage.getItem('token')
            }).then(res => {
                console.log(res.data)
                this.tableData = [];
                var stuName = ""
                 var stuClass = ""
                let list = res.data.data.beanList;
                this.subStuStateList = res.data.dict.subject.subStuState
                list.forEach((item, index) => {
                    if(item.student==null){
                         stuName = ""
                         stuClass =""
                    }else{
                         stuName = item.student.stuName
                         stuClass =item.student.stuClass
                    }
                    this.tableData.push({
                        subId: item.subId,
                        subName: item.subName,
                        subNature: item.subNature,
                        subNature: item.subNature,
                        subSource: item.subSource,
                        subTeaId: item.subTeaId,
                        subFile: item.subFile,
                        teafirstReportDeadlineMail: item.firstReportDeadline,
                        lastReportDeadline: item.lastReportDeadline,
                        stuId: item.stuId,
                        subStuState: this.subStuStateList[item.subStuState],
                        subLastScore: item.subLastScore,
                        showId: item.showId,
                        subIntroduce: item.subIntroduce,
                        stuName: stuName,
                        stuClass: stuClass,
                        teaName: item.teacher.teaName
                    })
                })
           
                this.pagination.total = res.data.data.totalRecord
                this.pagination.currentPage = res.data.data.currentPage

            }).catch(err => {
                 console.log(this.tableData)
                console.info('报错的信息', err);

            });
        },

        pageChange(page) {
            this.getData(page, this.pagination.pageSize)
        },
        pageSizeChange(pageSize) {
            this.getData(this.pagination.page, pageSize)
        },
        doSearch() {
            this.getData(1, this.pagination.pageSize)
             this.getStudent(1, this.pagination.pageSize)
        },


        handleCreate() {
            this.formData.subId = ''
            this.formData.subName = ''
            this.formData.subNature = ''
            this.formData.subSource = ''
            this.formData.subTeaId = ''
            this.formData.firstReportDeadline = ''
            this.formData.lastReportDeadline = ''
            this.formData.stuId = ''
            this.formData.subStuState = ''
            this.formData.subLastScore = ''
            this.formData.showId = ''
            this.formData.subIntroduce = ''
            this.dialogStatus = '新增'; //对应标题
            this.value3 = true

            // this.getData();
            // this.resetFormColumns();//重置
        },
        //多选
        changeSelect(e) {
            this.selectList = e;
            this.selectCount = e.length;
        },

        delAll() {
            if (this.selectCount <= 0) {
                this.$Message.warning("您还未选择要删除的数据");
                return;
            }
            console.log(this.selectList)
            var lstprimaryKey = []
            for (var i = 0; i < this.selectCount; i++) {
                lstprimaryKey.push(this.selectList[i].subId)
            }
            console.log(lstprimaryKey)
            this.$Modal.confirm({
                title: "确认删除",
                content: "您确认要删除所选的 " + this.selectCount + " 条数据?",
                onOk: () => {
                    this.$axios({
                        url: 'sub/deleteAll',
                        method: 'get', //请求的方式
                        params: { lstprimaryKey: lstprimaryKey },
                        paramsSerializer: params => {
                            return this.$Qs.stringify(params, { indices: false })
                        }

                        // token:localStorage.getItem('token')
                    }).then(res => {
                        console.log(res.data)
                        this.getData(1, 10);
                    }).catch(err => {
                        console.info('报错的信息', err);

                    });
                    this.$Message.success("操作成功");
                    //   this.clearSelectAll();
                    this.getData(1, 10);
                }
            });
        },
        handleRender() {
            this.$Modal.confirm({
                render: (h) => {
                    return h('Input', {
                        props: {
                            value: this.value,
                            autofocus: true,
                            placeholder: 'Please enter your name...'
                        },
                        on: {
                            input: (val) => {
                                this.value = val;
                            }
                        }
                    })
                }
            })
        },
        ok() {
            this.$refs.zq_formData.validate(valid => {
                if (valid) {
                    saveOrUpdateDemo(this.zq_formData)
                        .then(response => {
                            if (response.data.status == 1) {
                                this.getListPage();
                                this.$Notice.success({
                                    title: '成功',
                                    desc: '保存成功',
                                    duration: 2
                                });
                                this.drawer = false;
                            } else {
                                this.$message({
                                    message: response.data.message,
                                    type: 'error'
                                })
                            }
                        })
                        .catch(err => {
                            this.fetchSuccess = false;
                            console.log(err);
                        })
                }
            })
        },
        cancel() {
            this.drawer = false;
        },
        doReset() {
            this.formItem.subId = ''
            this.formItem.subName = ''
            this.formItem.subNature = ''
            this.formItem.subSource = ''
            this.formItem.subTeaId = ''
            this.formItem.firstReportDeadline = ''
            this.formItem.lastReportDeadline = ''
            this.formItem.stuId = ''
            this.formItem.subStuState = ''
            this.formItem.subLastScore = ''
            this.formItem.showId = ''
            this.formItem.subIntroduce = ''
            this.getData(1, 10);
            this.studentFormItem.stuId=''
            this.studentFormItem.stuName=''
            
        },
        ruler() {
            console.log(this.selectList)
            console.log(this.selectCount <= 0)
            if (this.selectCount <= 0) {
                this.$Message.warning("您还未选择要分配的课题");
                return;
            } else if (this.selectCount > 1) {
                this.$Message.warning("您每次只能为一个学生分配课题");
                return;
            } else if (this.selectList[0].subStuState != this.subStuStateList[1]) {
                this.$Message.warning("该课题已分配或待审核");
                return;
            }
            this.modal12 = true

        },
        distribution(row){
          var lstprimaryKey = {}
                lstprimaryKey = {
                    subId: this.selectList[0].subId,
                    subStuState: 3,
                    stuId:  row.stuId
                }


            
            console.log(this.lstprimaryKey)
            this.$axios({
                url: 'sub/listUpdate',
                method: 'post', //请求的方式
                data: [lstprimaryKey],
                // token:localStorage.getItem('token')
            }).then(res => {
                console.log(res.data)
                this.getData(1, 10);
            }).catch(err => {
                console.info('报错的信息', err);

            });
            this.$Message.success("分配 成功");
            this.modal12=false
        },
        toExamine(type) {
            if (this.selectCount <= 0) {
                this.$Message.warning("您还未选择课题");
                return;
            }
            for (var i = 0; i < this.selectCount; i++) {
                if (this.selectList[i].subStuState != this.subStuStateList[2]) {
                    this.$Message.warning("请正确选择需要审核的课题");
                    console.log(this.selectList)

                    return;
                }
            }

            var lstprimaryKey = new Array();
            var lstprimaryKey1 = {}
            for (var i = 0; i < this.selectCount; i++) {
                if (type === 1)
                    this.selectList[i].subStuState = 3
                else if (type === 0)
                    this.selectList[i].subStuState = 1
                lstprimaryKey1 = {
                    subId: this.selectList[i].subId,
                    subStuState:3,
                }

                lstprimaryKey.push(lstprimaryKey1)

            }
            console.log(this.lstprimaryKey)
            this.$axios({
                url: 'sub/listUpdate',
                method: 'post', //请求的方式
                data: lstprimaryKey,
                // token:localStorage.getItem('token')
            }).then(res => {
                console.log(res.data)
                this.getData(1, 10);
            }).catch(err => {
                console.info('报错的信息', err);

            });
            this.$Message.success("操作成功");
            //   this.clearSelectAll();

        },
    getStudent(page, pageSize){
        let params = this.studentFormItem
        let token = localStorage.getItem('token')
        this.$axios({

            url: 'stu/list?page=' + page + '&pageSize=' + pageSize,
            method: 'get', //请求的方式
            params: params,
            // token:localStorage.getItem('token')
        }).then(res => {
            console.log(res.data)
            this.tableData1 = [];
            let list = res.data.data.beanList;
            list.forEach((item, index) => {
                this.tableData1.push({
                    stuId: item.stuId,
                    stuPassword: item.stuPassword,
                    stuName: item.stuName,
                    stuMajor: item.stuMajor,
                    stuClass: item.stuClass,
                    stuSex: item.stuSex,
                    stuAge: item.stuAge,
                    stuBirthday: item.stuBirthday,
                    stuPhone: item.stuPhone,
                    stuMail: item.stuMail,
                    stuAddress: item.stuAddress,
                    stuRemarks: item.stuRemarks,
                    academyId: item.academyId,
                    //   academy: item.academy
                })
            })

            //  this.pagination.total =res.data.data.totalRecord
            //  this.pagination.currentPage =res.data.data.currentPage

        }).catch(err => {
            console.info('报错的信息', err);

        });
    },
    
    exportDataDemo(type) {

        window.location.href = "http://47.100.136.105:8080/downFile/exportDemo?type=" + type


    }
    },
};
</script>
<style>
.demo-drawer-footer {
    width: 100%;
    position: absolute;
    bottom: 0;
    left: 0;
    border-top: 1px solid #e8e8e8;
    padding: 10px 16px;
    text-align: right;
    background: #fff;
}
</style>