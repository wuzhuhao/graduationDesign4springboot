<style lang="postcss" scoped>
.home-container{

}
</style>
<template>
<section class="home-container">
    <MasterPage title="首页">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        <div slot="title-toolbar">
            <Button type="primary" icon="md-add"  @click="handleCreate">新增</Button>
        </div>

        <!-- 条件搜索 -->
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="80">
              <Row>
                <Col span="8">
                  <FormItem label="id：">
                    <Input v-model="formItem.stuId" placeholder="请输入id"></Input>
                </FormItem>
                </Col>
                <Col span="8">
                  <FormItem label="姓名：">
                    <Input v-model="formItem.stuName" placeholder="请输入姓名"></Input>
                </FormItem>
                </Col>
                <Col span="8">
                  <FormItem label="学院：">
                    <Select v-model="formItem.select">
                        <Option value="beijing">New York</Option>
                        <Option value="shanghai">London</Option>
                        <Option value="shenzhen">Sydney</Option>
                    </Select>
                </FormItem>
                </Col>
                 
              </Row>
          </Form>
        </div>
        <div slot="search">
            
          <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doSearch">查询</Button>  &nbsp; &nbsp; &nbsp; &nbsp;
           <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doReset">重置</Button>  &nbsp;
          <Button type="info"  style="float:left;margin:0 8px"  @click="exportData(1)"><Icon type="ios-download-outline"></Icon>导出数据</Button>&nbsp;
          <Button type="info" icon="ios-search;margin:0 8px"  style="float:left" @click="delAll">批量删除</Button>  &nbsp;
        <Upload action="http://localhost:8080/graManagement/uploadFile/importUserByExcel?type=1"    style="float:left;margin:0 8px">
            <Button  type="info" icon="ios-cloud-upload-outline">批量注册</Button>
        </Upload>
         <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataDemo(1)"><Icon type="ios-download-outline"></Icon>导出注册模板</Button>&nbsp;
        </div>
        <div slot="btns">
          <Button type="primary" icon="md-add" @click="handleCreate">添加</Button>
        </div>
        <div slot="paddingContent">
          <Table border  show-summary :columns="columns2" :data="tableData"  @on-selection-change="changeSelect" ref="table"></Table>
        </div>
        <div slot="pager">
            <Page :total="this.pagination.total"  :page-size="this.pagination.pageSize"  :page-size-opts="this.pagination.pageSizeOpts" 
            :current="this.pagination.currentPage"  @on-change="pageChange" @on-page-size-change="pageSizeChange"  show-elevator show-total show-sizer />
        </div>    

    </MasterPage>


    <!--  添加和编辑弹出抽屉  +++++++++++++++++++++++++++++++++++++++++++++++++++++     -->
        <!--  :title 加:为绑定数据 即实现自定义标题  -->
       <Drawer
            :title='this.dialogStatus'
            v-model="value3"
            width="720"
            :mask-closable="false"
            :styles="styles"
        >
            <Form :model="formData">
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="账号" label-position="top">
                            <Input v-model="formData.stuId" placeholder="请输入账号" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="密码" label-position="top">
                            <Input v-model="formData.stuPassword" placeholder="请输入密码">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="名称" label-position="top">
                            <Input v-model="formData.stuName" placeholder="请输入名称" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="专业" label-position="top">
                            <Input v-model="formData.stuMajor" placeholder="请输入专业">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="班级" label-position="top">
                            <Input v-model="formData.stuClass" placeholder="请输入班级" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="性别" label-position="top">
                            <Input v-model="formData.stuSex" placeholder="请输入性别">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="年龄" label-position="top">
                            <Input v-model="formData.stuAge" placeholder="请输入年龄" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="生日" label-position="top">
                            <Input v-model="formData.stuBirthday" placeholder="请输入生日">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="电话" label-position="top">
                            <Input v-model="formData.stuPhone" placeholder="请输入电话" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="邮箱" label-position="top">
                            <Input v-model="formData.stuMail" placeholder="请输入邮箱">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="地址" label-position="top">
                            <Input v-model="formData.stuAddress" placeholder="请输入地址" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="备注" label-position="top">
                            <Input v-model="formData.stuRemarks" placeholder="请输入备注">
                            </Input>
                        </FormItem>
                    </Col>
                </Row></Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="学院" label-position="top">
                            <Input v-model="formData.academyId" placeholder="请输入学院" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="邮箱" label-position="top">
                            <Input v-model="formData.stuMail" placeholder="请输入邮箱">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="学院id" label-position="top">
                            <Input v-model="formData.academyId" placeholder="请输入学院id" />
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <div class="demo-drawer-footer">
                <Button style="margin-right: 8px" @click="value3 = false">Cancel</Button>
                <Button type="primary" @click="update()">Submit</Button>
            </div>
        </Drawer>    
  
</section>



 
</template>
<script>
import MasterPage from '@/components/Master'

export default {
    components:{
        MasterPage
    },
    data(){
      
      return{
          dialogStatus: '',//title自定义标题
          value3: false,
                styles: {
                    height: 'calc(100% - 55px)',
                    overflow: 'auto',
                    paddingBottom: '53px',
                    position: 'static'
                },
                formData: {
                    stuId: '',
                    stuPassword: '',
                    stuName:  '',
                    stuMajor: '',
                    stuClass:  '',
                    stuSex:  '',
                    stuAge: '',
                    stuBirthday:  '',
                    stuPhone:  '',
                    stuMail:  '',
                    stuAddress:  '',
                    stuRemarks: '',
                    academyId:  '',
                    // academy:  '',
                },
            
        pagination: {
                pageSize:10,
                page: 1,
                total:0,
                pageSizeOpts:[5, 10, 15, 20,25,30],
                currentPage:1
        },
         selectList: [], // 多选数据
         selectCount: 0, // 多选计数
        tableData:[],
        formItem: {
          stuId: '',
          stuPassword: '',
          stuName:  '',
          stuMajor: '',
          stuClass:  '',
          stuSex:  '',
          stuAge: '',
          stuBirthday:  '',
          stuPhone:  '',
          stuMail:  '',
          stuAddress:  '',
          stuRemarks: '',
          academyId:  '',
        //   academy:  '',
        },
        columns2: [
            {
               type: 'selection',
               width: 60,
               align: 'center',
              fixed: 'left'
             },
           
            {
                title: '账号',
                key: 'stuId',
                 width: 100,
                fixed: 'left',
                sortable: true
            },
            {
                title: '密码',
                key: 'stuPassword',
                minWidth: 100,
                
            },
            {
                title: '姓名',
                key: 'stuName',
                minWidth: 100,
            }, {
                title: '专业',
                key: 'stuMajor',
                minWidth: 100,
            },
            {
                title: '班级',
                key: 'stuClass',
                minWidth: 100,
            },
            {
                title: '性别',
                key: 'stuSex',
                minWidth: 100,
            } ,
            {
                title: '年龄',
                key: 'stuAge',
                minWidth: 100,
            },
            {
                title: '生日',
                key: 'stuBirthday',
                minWidth: 100,
            },
            {
                title: '电话',
                key: 'stuPhone',
                minWidth: 100,
            }, {
                title: '邮箱',
                key: 'stuMail',
                minWidth: 100,
            },{
                title: '地址',
                key: 'stuAddress',
                minWidth: 100,
            },
            {
                title: '备注',
                key: 'stuRemarks',
                minWidth: 100,
            }, {
                title: '学院',
                key: 'academyId',
                minWidth: 100,
            },{
                        title: '操作',
                        key: 'action',
                        fixed: 'right',
                        minWidth: 120,
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                       type: 'primary',
                                        size: 'small',
                                        icon: "icon iconfont icon-shanchu"
                                    },
                                     attrs:{
                                        title:'删除'
                                    },
                                      on: {
                                        click: () => {
                                        this.delById(params.row)             //编辑方法
                                        }
                                      }
                                }),
                                h('Button', {
                                    props: {
                                        type: 'text',
                                        size: 'small',
                                        icon:'icon iconfont icon-edit'
                                    },
                                     attrs:{
                                        title:'编辑'
                                    },
                                      on: {
                                        click: () => {
                                        this.edit(params.row)             //编辑方法
                                        }
                                      }
                                })
                            ]);
                        }
                    }
        ]
      }
    },
  
     created(){
        this.getData(1,10);
     },
    methods:{
       exportData (type) {
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
            } ,
      
      // watch: {
      //   // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
      //     '$route': 'getParams'
      // },
      //编辑
        edit(row){
            this.dialogStatus = '编辑';//对应标题
            this.formData.stuId = row.stuId
            this.formData.stuPassword = row.stuPassword
            this.formData.stuName =  row.stuName
            this.formData.stuMajor =  row.stuMajor
            this.formData.stuClass =  row.stuClass
            this.formData.stuSex =  row.stuSex
            this.formData.stuAge = row.stuAge
            this.formData.stuBirthday =  row.stuBirthday
            this.formData.stuPhone =  row.stuPhone
            this.formData.stuMail =  row.stuMail
             this.formData.stuAddress =  row.stuAddress
            this.formData.stuRemarks =  row.stuRemarks
            this.formData.academyId =  row.academyId
            this.value3 = true
        },
        delById(row) {
            this.$Modal.confirm({
                title: "确认删除",
                content: "您确认要删除?",
                onOk: () => {
                    console.log(row)
                 this.$axios({     
                            url: 'stu/delete/' + row.stuId,
                            method: 'delete',//请求的方式
                            data:this.$Qs.stringify(this.formData),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                           this.getData(1,10);
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                }
            });
           
    },
      update(){
          console.log(this.formData)
        if(this.dialogStatus == '新增'){
            this.$axios({     
                            url: 'stu/add',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify(this.formData),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                        this.getData(1,10)
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                        this.value3 = false
        }else if(this.dialogStatus == '编辑'){
             this.$axios({     
                            url: 'stu/update',
                            method: 'put',//请求的方式
                            data:this.$Qs.stringify(this.formData),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                        this.getData(1,10)
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                        this.value3 = false
        }
   
      },
      getData(page,pageSize){
        let params = this.formItem
       let  token = localStorage.getItem('token')
         this.$axios({
                            
                            url: 'stu/list?page=' + page  + '&pageSize=' + pageSize,
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                           this.tableData.push({
                              stuId: item.stuId,
                              stuPassword: item.stuPassword,
                              stuName: item.stuName,
                              stuMajor: item.stuMajor,
                              stuClass: item.stuClass,
                              stuSex: item.stuSex,
                              stuAge:item.stuAge,
                              stuBirthday: item.stuBirthday,
                              stuPhone: item.stuPhone,
                              stuMail: item.stuMail,
                              stuAddress: item.stuAddress,
                              stuRemarks: item.stuRemarks,
                              academyId: item.academyId,
                            //   academy: item.academy
                           })
                          })
                  
                           this.pagination.total =res.data.data.totalRecord
                           this.pagination.currentPage =res.data.data.currentPage
                          
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
      },

      pageChange(page){
          this.getData(page,this.pagination.pageSize)
      },
      pageSizeChange(pageSize){
          this.getData(this.pagination.page,pageSize)
      },
      doSearch(){
         this.getData(1,this.pagination.pageSize)
      },
     
   
       handleCreate () {
        this.formData.stuId = ''
        this.formData.stuPassword = ''
        this.formData.stuName = ''
        this.formData.stuMajor = ''
        this.formData.stuClass = ''
        this.formData.stuSex = ''
        this.formData.stuAge = ''
        this.formData.stuBirthday = ''
        this.formData.stuPhone = ''
        this.formData.stuMail = ''
        this.formData.stuAddress = ''
        this.formData.stuRemarks = ''
        this.formData.academyId = ''
        this.dialogStatus = '新增';//对应标题
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
    for(var i = 0;i<this.selectCount;i++){
		lstprimaryKey.push(this.selectList[i].stuId)
	}
     console.log(lstprimaryKey)
      this.$Modal.confirm({
        title: "确认删除",
        content: "您确认要删除所选的 " + this.selectCount + " 条数据?",
        onOk: () => {
           this.$axios({     
                            url: 'stu/deleteAll',
                            method: 'delete',//请求的方式
                            params: {lstprimaryKey:lstprimaryKey},
                            paramsSerializer: params => {
                                return this.$Qs.stringify(params, { indices: false })
                            }
                           
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                           this.getData(1,10);
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
          this.$Message.success("操作成功");
        //   this.clearSelectAll();
          this.getData();
        }
      });
    },
       handleRender () {
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
       ok () {
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
      cancel () {
        this.drawer = false;
      },
      doReset(){
        this.formItem.stuId = ''
        this.formItem.stuPassword = ''
        this.formItem.stuName = ''
        this.formItem.stuMajor = ''
        this.formItem.stuClass = ''
        this.formItem.stuSex = ''
        this.formItem.stuAge = ''
        this.formItem.stuBirthday = ''
        this.formItem.stuPhone = ''
        this.formItem.stuMail = ''
        this.formItem.stuAddress = ''
        this.formItem.stuRemarks = ''
        this.formItem.academyId = ''
         this.getData(1,10);
    },
    exportDataDemo(type){
      
            window.location.href="http://localhost:8080/graManagement/downFile/exportDemo?type=" + type
        
    }
    
    }
};
</script>
<style>
    .demo-drawer-footer{
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