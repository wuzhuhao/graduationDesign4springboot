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
                  <FormItem label="任务编号">
                    <Input v-model="formItem.id" placeholder="请输入任务编号"></Input>
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
            <Form :model="formItem">
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="任务编号" label-position="top">
                            <Input v-model="formItem.id" placeholder="请输入任务编号" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="主要内容" label-position="top">
                            <Input v-model="formItem.task_content" placeholder="请输入主要内容">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="基本要求" label-position="top">
                            <Input v-model="formItem.task_require" placeholder="请输入基本要求" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="任务调度" label-position="top">
                            <Input v-model="formItem.task_schedule" placeholder="请输入任务调度">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="应收集的资料及主要参考文献" label-position="top">
                            <Input v-model="formItem.task_literature" placeholder="请输入应收集的资料及主要参考文献" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="任务附件" label-position="top">
                            <Input v-model="formItem.task_file" placeholder="请输入任务附件">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="任务状态" label-position="top">
                            <Input v-model="formItem.task_state" placeholder="请输入任务状态" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="点击次数" label-position="top">
                            <Input v-model="formItem.task_number" placeholder="请输入点击次数">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="课题id" label-position="top">
                            <Input v-model="formItem.task_sub_id" placeholder="请输入课题id" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="回复内容" label-position="top">
                            <Input v-model="formItem.reply_content" placeholder="请输入回复内容">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="回复附件" label-position="top">
                            <Input v-model="formItem.task_sub_id" placeholder="请输入回复附件" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="任务发布时间" label-position="top">
                            <Input v-model="formItem.reply_content" placeholder="请输入任务发布时间">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="回复时间" label-position="top">
                            <Input v-model="formItem.task_sub_id" placeholder="请输入回复时间" />
                        </FormItem>
                    </Col>
                </Row>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="任务发布时间" label-position="top">
                            <Input v-model="formItem.taskSchedule" placeholder="请输入任务发布时间" />
                        </FormItem>
                    </Col>
                </Row>
                 </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="回复时间" label-position="top">
                            <Input v-model="formItem.taskLiterature" placeholder="请输入回复时间" />
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
                formItem: {
                  id: '',
                  taskFile: '',
                  taskState: '',
                  taskNumber:'',
                  taskSubId:'',
                  replyFile:'',
                  taskTime: '',
                  replyTime: '',
                  taskContent:'',
                  taskRequire: '',
                  taskSchedule: '',
                  taskLiterature:'',
                  replyContent:'',
                  subject:''
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
          id: '',
          taskFile: '',
          taskState: '',
          taskNumber:'',
          taskSubId:'',
          replyFile:'',
          taskTime: '',
          replyTime: '',
          taskContent:'',
          taskRequire: '',
          taskSchedule: '',
          taskLiterature:'',
          replyContent:'',
          subject:''
        },
        columns2: [
            {
               type: 'selection',
               width: 60,
               align: 'center',
              fixed: 'left'
             },
            
             {
                title: '任务编号',
                key: 'id',
                 width: 120,
                 minWidth: 120,
                fixed: 'left',
                sortable: true
            },
            {
                title: '主要内容',
                key: 'taskContent',
                 tooltip:true,
                minWidth: 100,
            },
            {
                title: '基本要求',
                key: 'taskRequire',
                 tooltip:true,
                minWidth: 100,
            }, {
                title: '任务调度',
                key: 'taskSchedule',
                 tooltip:true,
                minWidth: 100,
            },
            {
                title: '应收集的资料及主要参考文献',
                key: 'taskLiterature',
                 tooltip:true,
                minWidth: 200,
            },
           
           
            {
                title: '课题名称',
                key: 'subName',
                minWidth: 200,
            },{
                        title: '操作',
                        key: 'action',
                        fixed: 'right',
                        width: 120,
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
            this.formItem.id = row.id
            this.formItem.taskFile = row.taskFile
            this.formItem.taskState =  row.taskState
            this.formItem.taskNumber =  row.taskNumber
            this.formItem.taskSubId =  row.taskSubId
            this.formItem.replyFile = row.replyFile
            this.formItem.taskTime =  row.taskTime
            this.formItem.replyTime =  row.replyTime
            this.formItem.taskContent =  row.taskContent
            this.formItem.taskRequire = row.taskRequire
            this.formItem.taskSchedule =  row.taskSchedule
            this.formItem.taskLiterature =  row.taskLiterature
            this.formItem.replyContent =  row.replyContent
            this.formItem.subject =  row.subject
            this.value3 = true
        },
        delById(row) {
            this.$Modal.confirm({
                title: "确认删除",
                content: "您确认要删除?",
                onOk: () => {
                    console.log(row)
                 this.$axios({     
                            url: 'task/delete/' + row.teaId,
                            method: 'get',//请求的方式
                            data:this.$Qs.stringify(this.formItem),
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
          console.log(this.formItem)
        if(this.dialogStatus == '新增'){
            this.$axios({     
                            url: 'task/add',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify(this.formItem),
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
                            url: 'task/update',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify(this.formItem),
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
                            
                            url: 'task/list?page=' + page  + '&pageSize=' + pageSize,
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                           this.tableData.push({
                              id : item.id,
                              taskFile :item.taskFile,
                              taskState : item.taskState,
                              taskNumber : item.taskNumber,
                              taskSubId : item.taskSubId,
                              replyFile : item.replyFile,
                              taskTime : item.taskTime,
                              replyTime : item.replyTime,
                              taskContent : item.taskContent,
                              taskRequire : item.taskRequire,
                              taskSchedule : item.taskSchedule,
                              taskLiterature : item.taskLiterature,
                              replyContent : item.replyContent,
                              subName : item.subject.subName,
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
            this.formItem.id = '',
            this.formItem.taskFile  = '',
            this.formItem.taskState =  '',
            this.formItem.taskNumber =  '',
            this.formItem.taskSubId =  '',
            this.formItem.replyFile = '',
            this.formItem.taskTime =  '',
            this.formItem.replyTime =  '',
            this.formItem.taskContent =  '',
            this.formItem.taskRequire = '',
            this.formItem.taskSchedule =  '',
            this.formItem.taskLiterature =  '',
            this.formItem.replyContent =  '',
            this.formItem.subject = '',
            this.value3 = true
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
		lstprimaryKey.push(this.selectList[i].id)
	}
     console.log(lstprimaryKey)
      this.$Modal.confirm({
        title: "确认删除",
        content: "您确认要删除所选的 " + this.selectCount + " 条数据?",
        onOk: () => {
           this.$axios({     
                            url: 'task/deleteAll',
                            method: 'get',//请求的方式
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
        this.$refs.zq_formItem.validate(valid => {
          if (valid) {
            saveOrUpdateDemo(this.zq_formItem)
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
            this.formItem.id = '',
            this.formItem.taskFile  = '',
            this.formItem.taskState =  '',
            this.formItem.taskNumber =  '',
            this.formItem.taskSubId =  '',
            this.formItem.replyFile = '',
            this.formItem.taskTime =  '',
            this.formItem.replyTime =  '',
            this.formItem.taskContent =  '',
            this.formItem.taskRequire = '',
            this.formItem.taskSchedule =  '',
            this.formItem.taskLiterature =  '',
            this.formItem.replyContent =  '',
            this.formItem.subject = '',
        this.getData(1,10);
    },
    exportDataDemo(type){
       
            window.location.href="http://47.100.136.105:8080/downFile/exportDemo?type=" + type
        
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