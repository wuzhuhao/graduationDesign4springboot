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

        
        <div slot="paddingContent">
          <Table border  show-summary :columns="columns2" :data="tableData"  @on-selection-change="changeSelect" ref="table"></Table>
        </div>
        <div slot="pager">
            <Page :total="this.pagination.total"  :page-size="this.pagination.pageSize"  :page-size-opts="this.pagination.pageSizeOpts" 
            :current="this.pagination.currentPage"  @on-change="pageChange" @on-page-size-change="pageSizeChange"  show-elevator show-total show-sizer />
        </div>    

    </MasterPage>

 <Modal v-model="modal11"   closable  :styles="{top: '10px'}":width='1200' >
        <info></info>
    </Modal>
  
</section>



 
</template>
<script>
import MasterPage from '@/components/Master'
import info from './checkReportInfo'
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
          reportSubId: "",
          reportType: "",
          id: "",
          reportState: "",
          reportSubtime: "",
          reportVersion: "",
          reportFile: "",
          reportTemp: "",
          reportContent: "",
          stuMessage: "",
          teaSuggestion: "",
          subject: "",
          subName: "",
          teaName:"",
          stuName:""
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
                key: 'subName',
                 minWidth: 220,
                sortable: true
            },
            {
                title: '所属专业',
                key: 'stuMajor',
                minWidth: 100,
                sortable: true
            },
            {
                title: '指导老师',
                key: 'teaName',
                 minWidth: 100,
                sortable: true
            },
            {
                title: '学生',
                key: 'stuName',
                  minWidth: 100,
               
            },
            {
                title: '版本',
                key: 'reportVersion',
                
            },
            {
                title: '状态',
                key: 'reportState',
                
            }, {
                title: '创建时间',
                key: 'reportSubtime',
                 minWidth: 220,
               
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
                                       
                                    },
                                     attrs:{
                                        title:'上传论文'
                                    },
                                      on: {
                                        click: () => {
                                        this.select(params.row)            //编辑方法
                                        }
                                      }
                                },'上传论文')
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
       this.modal11 = true;
      },
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
                            method: 'delete',//请求的方式
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
        let userId = localStorage.getItem("userId") 
       let  token = localStorage.getItem('token')
         this.$axios({
                            
                            url: 'report/listOfTea',
                            method: 'get',//请求的方式
                            params:{
                              page:page,
                              pageSize:pageSize,
                              teaId:userId,
                              reportType:2
                            },
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                           this.tableData.push({
                              reportSubId: item.reportSubId,
                              reportType: item.reportType,
                              id: item.id,
                              reportState: item.reportState,
                              reportSubtime: item.reportSubtime,
                              reportVersion: item.reportVersion,
                              reportFile: item.reportFile,
                              reportTemp: item.reportTemp,
                              reportContent: item.reportContent,
                              stuMessage: item.stuMessage,
                              teaSuggestion: item.teaSuggestion,
                              subject: item.subject,
                              stuMajor:item.subject.student.stuMajor,
                              subName:item.subject.subName,
                              teaName:item.subject.teacher.teaName,
                              stuName:item.subject.student.stuName
                           })
                          })
                  
                           this.pagination.total =res.data.data.totalRecord
                           this.pagination.currentPage =res.data.data.currentPage
                          console.log(this.tableData)
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