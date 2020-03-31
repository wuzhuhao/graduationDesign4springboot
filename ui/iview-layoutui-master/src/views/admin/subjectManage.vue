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
                  <FormItem label="课题名称">
                    <Input v-model="formItem.subName" placeholder="请输入课题名称"></Input>
                </FormItem>
                </Col>
                <Col span="8">
                  <FormItem label="导师">
                    <Input v-model="formItem.subName" placeholder="请输入导师id"></Input>
                </FormItem>
                </Col>
                <Col span="8">
                  <FormItem label="课程性质">
                     <Select v-model="formItem.subNature">
    
                            <Option v-for="(item,index) in subNatureList" :value="index"  >{{item}} </Option>
    
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
        </div>
        <div slot="btns">
          <Button type="primary" icon="md-add" @click="handleCreate">添加</Button>
        </div>
        <div slot="paddingContent">
          <Table border   :columns="columns2" :data="tableData"  @on-selection-change="changeSelect" ref="table"></Table>
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
<!--                    <Col span="12">-->
<!--                        <FormItem label="id" label-position="top">-->
<!--                            <Input v-model="formData.subId" placeholder="请输入id" />-->
<!--                        </FormItem>-->
<!--                    </Col>-->
                    <Col span="12">
                        <FormItem label="课题名称" label-position="top">
                            <Input v-model="formData.subName" placeholder="请输入课题名称">
                            </Input>
                        </FormItem>
                    </Col>
                       <Col span="12">
                        <FormItem label="导师" label-position="top">
                            <Input v-model="formData.teaId" placeholder="请输入导师id">
                            </Input>
                        </FormItem>
                    </Col>
               
                </Row>
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="课题性质" label-position="top">
                               <Select v-model="formData.subNature">
    
                            <Option v-for="(item,index) in subNatureList" :value="index"  >{{item}} </Option>
    
                        </Select>
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="课题来源" label-position="top">
                              <Select v-model="formData.subSource">
    
                            <Option v-for="(item,index) in subSourceList" :value="index"  >{{item}} </Option>
    
                        </Select>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="开题报告截止期限" label-position="top">
                              <DatePicker type="date" placeholder="请选择"   size="large" v-model="formData.firstReportDeadline" style="width:100%"></DatePicker>     
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="论文定稿截止期限" label-position="top">
                             <DatePicker type="date" placeholder="请选择"   size="large" v-model="formItem.lastReportDeadline" style="width:100%"></DatePicker>     
                            </Input>
                        </FormItem>
                    </Col>
               
<!--                    <Col span="12">-->
<!--                        <FormItem label="总评" label-position="top">-->
<!--                            <Input v-model="formData.subLastScore" placeholder="请输入总评" />-->
<!--                        </FormItem>-->
<!--                    </Col>-->
<!--                    <Col span="12">-->
<!--                        <FormItem label="展示id" label-position="top">-->
<!--                            <Input v-model="formData.showId" placeholder="请输入展示id">-->
<!--                            </Input>-->
<!--                        </FormItem>-->
<!--                    </Col>-->
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
             subStuStateList:{},
                subNatureList:{},
                subSourceList:{},
          value3: false,
                styles: {
                    height: 'calc(100% - 55px)',
                    overflow: 'auto',
                    paddingBottom: '53px',
                    position: 'static'
                },
                formData: {
                   subId: '',
                    subName: '',
                    subNature: '',
                    subSource: '',
                    subTeaId: '',
                    subFile:'',
                    firstReportDeadline: '',
                    lastReportDeadline:'',
                    stuId:'',
                    subStuState: '',
                    subLastScore:'',
                    showId:'',
                    subIntroduce: '',
                    student:'',
                    teacher: '',
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
             subId: '',
            subName: '',
            subNature: '',
            subSource: '',
            subTeaId: '',
            subFile:'',
            firstReportDeadline: '',
            lastReportDeadline:'',
            stuId:'',
            subStuState: '',
            subLastScore:'',
            showId:'',
            subIntroduce: '',
        },
        columns2: [
             {
               type: 'selection',
               width: 60,
               align: 'center',
              fixed: 'left'
             },
            {
               type: 'index',
                title: '序号',
               width: 80,
               align: 'center',
              fixed: 'left'
             },
            {
                title: '课题名称',
                key: 'subName',
               minWidth: 200,
                fixed: 'left'
            },
            {
                title: '课题性质',
                key: 'subNature',
                minWidth: 100,
            },
            {
                title: '课程来源',
                key: 'subSource',
                minWidth: 100,
            }, {
                title: '课题介绍',
                key: 'subIntroduce',
                tooltip:true,
                minWidth: 200,
            },
            {
                title: '课题导师',
                key: 'subTeaId',
                minWidth: 100,
            },
            {
                title: '开题报告截止',
                key: 'firstReportDeadline',
                minWidth: 150,
            } ,
            {
                title: '论文定稿截止',
                key: 'lastReportDeadline',
                minWidth: 150,
            },
           
            {
                title: '选定状态',
                key: 'subStuState',
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
                                        type: 'text',
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
            this.formData.subId = row.subId
            this.formData.subName = row.subName
            this.formData.subNature =  row.subNature
            this.formData.subSource =  row.subSource
            this.formData.subTeaId =  row.subTeaId
            this.formData.subFile =  row.subFile
            this.formData.firstReportDeadline = row.firstReportDeadline
            this.formData.lastReportDeadline =  row.lastReportDeadline
            this.formData.stuId =  row.stuId
            this.formData.subStuState =  row.subStuState
            this.formData.subLastScore =  row.subLastScore
            this.formData.showId = row.showId
            this.formData.subIntroduce = row.subIntroduce
            this.formData.subNature =  row.subNature
            this.formData.subSource =  row.subSource
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
                            url: 'sub/add',
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
                            url: 'sub/update',
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
        }
   
      },
      getData(page,pageSize){
        let params = this.formItem
       let  token = localStorage.getItem('token')
         this.$axios({
                            
                            url: 'sub/list?page=' + page  + '&pageSize=' + pageSize,
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                        
                         this.tableData = [];
                          let list = res.data.data.beanList;
                            this.subStuStateList = res.data.dict.subject.subStuState
                           this.subNatureList = res.data.dict.subject.subNature
                           this.subSourceList = res.data.dict.subject.subSource
                              console.log(  this.subSourceList)
                          list.forEach((item, index) => {
                           this.tableData.push({
                              subId: item.subId,
                              subName: item.subName,
                              subNature: this.subNatureList[item.subNature],
                               subLastScore: item.subLastScore,
                              subSource:this.subSourceList[item.subSource],
                              subTeaId:item.subTeaId,
                              subFile:item.subFile,
                              firstReportDeadline:item.firstReportDeadline,
                              lastReportDeadline:item.lastReportDeadline,
                              subStuState:  this.subStuStateList[item.subStuState],
                              showId: item.showId,
                              subIntroduce: item.subIntroduce,
     
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
		lstprimaryKey.push(this.selectList[i].subId)
	}
     console.log(lstprimaryKey)
      this.$Modal.confirm({
        title: "确认删除",
        content: "您确认要删除所选的 " + this.selectCount + " 条数据?",
        onOk: () => {
           this.$axios({     
                            url: 'sub/deleteAll',
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