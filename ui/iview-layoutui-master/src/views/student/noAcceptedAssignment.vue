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
      

        <!-- 条件搜索 -->
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="80">
              <Row>
                <Col span="8">
                  <FormItem label="课题标题">
                    <Input v-model="formItem.subName" placeholder="请输入课题标题"></Input>
                </FormItem>
                </Col>
               
                 
              </Row>
          </Form>
        </div>
        <div slot="search">
            
          <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doSearch">查询</Button>  &nbsp; &nbsp; &nbsp; &nbsp;
         
        </div>
        <div slot="paddingContent">
          <Table border   :columns="columns2" :data="tableData"  @on-selection-change="changeSelect" ref="table"></Table>
        </div>
        <div slot="pager">
            <Page :total="this.pagination.total"  :page-size="this.pagination.pageSize"  :page-size-opts="this.pagination.pageSizeOpts" 
            :current="this.pagination.currentPage"  @on-change="pageChange" @on-page-size-change="pageSizeChange"  show-elevator show-total show-sizer />
        </div>    

    </MasterPage>

 <Modal v-model="modal11"   closable  :styles="{top: '10px'}":width='1000' >
        <info></info>
    </Modal>
  
</section>



 
</template>
<script>
import MasterPage from '@/components/Master'
import info from './acceptedAssignmentInfo'
export default {
    components:{
        MasterPage,
        info
    },
    data(){
      
      return{
                modal11: false,
                styles: {
                    height: 'calc(100% - 55px)',
                    overflow: 'auto',
                    paddingBottom: '53px',
                    position: 'static'
                },
        taskStateList:[],
            
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
          formData: {
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
            subject:'',
            taskSubName:'',
            teaName:'',
            stuName:'',
            stuClass:'',
            subName:''
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
          subject:'',
          taskSubName:'',
          teaName:'',
          stuName:'',
          stuClass:'',
        },
        columns2: [
            {
              title: '序号',
              type: 'index',
              width: 150,
              fixed: 'left',
              align: 'center'
            }, 
            
             {
                title: '课题名称',
                key: 'taskSubName',
                 width: 300,
                fixed: 'left',
                sortable: true
            },
            {
                title: '指导老师',
                key: 'teaName',
                minWidth: 100,
            },
            {
                title: '学生',
                key: 'stuName',
                minWidth: 100,
            }, {
                title: '专业',
                key: 'stuClass',
                minWidth: 100,
            },
            {
                title: '任务状态',
                key: 'taskState',
                minWidth: 100,
            },{
                        title: '操作',
                        key: 'action',
                        fixed: 'right',
                        width:140,
                        minWidth: 140,
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small',
                                       
                                    },
                                    style: {
                                        marginRight: '5px'
                                        },
                                     attrs:{
                                        title:'查看'
                                    },
                                      on: {
                                        click: () => {
                                        this.select(params.row)            //编辑方法
                                        }
                                      }
                                },'查看'),
                                  h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small',
                                       
                                    },
                                     attrs:{
                                        title:'接收'
                                    },
                                      on: {
                                        click: () => {
                                        this.receive(params.row)            //编辑方法
                                        }
                                      }
                                },'接收')
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
        select(row){
          this.$store.commit('taskId',row.id);
       this.modal11 = true;
      },
    
      
      // watch: {
      //   // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
      //     '$route': 'getParams'
      // },
      //编辑
        receive(row){
              this.$axios({     
                            url: 'task/update',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify({
                              id:row.id,  //修改成待接受
                              taskState:2
                            }),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                        this.getData(1,10)
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });


        },
      
     
      getData(page,pageSize){
        let userId = localStorage.getItem("userId") 
       let  token = localStorage.getItem('token')
        this.formItem.taskState=1
        this.formItem.stuId= userId
        let params = this.formItem
        
         this.$axios({
                            
                            url: 'task/list?isJoinSubject=true',
                            method: 'get',//请求的方式
                             params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                           this.taskStateList = res.data.dict.task.taskState
                          list.forEach((item, index) => {
                           this.tableData.push({
                              id : item.id,
                              taskFile :item.taskFile,
                              taskState :  this.taskStateList[item.taskState],
                              taskNumber : item.taskNumber,
                              taskSubName : item.subject.subName,
                              teaName: item.subject.teacher.teaName,
                              stuName: (item.subject.student==null||item.subject.student==undefined)?'':item.subject.student.stuName,
                              stuClass: item.subject.student.stuClass,
                              replyFile : item.replyFile,
                              taskTime : item.taskTime,
                              replyTime : item.replyTime,
                              taskContent : item.taskContent,
                              taskRequire : item.taskRequire,
                              taskSchedule : item.taskSchedule,
                              taskLiterature : item.taskLiterature,
                              replyContent : item.replyContent,
                              subject : item.subject,
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