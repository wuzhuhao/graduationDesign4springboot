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
            <Button type="primary" icon="md-add"  @click="modal12=true">新增</Button>
        </div>
        <div slot="paddingContent">
          <Table border  show-summary :columns="columns2" :data="tableData"  @on-selection-change="changeSelect" ref="table"></Table>
        </div>
        <div slot="pager">
            <Page :total="this.pagination.total"  :page-size="this.pagination.pageSize"  :page-size-opts="this.pagination.pageSizeOpts" 
            :current="this.pagination.currentPage"  @on-change="pageChange" @on-page-size-change="pageSizeChange"  show-elevator show-total show-sizer />
        </div>    

    </MasterPage>

<Modal v-model="modal11"   closable @on-ok='edit' :styles="{top: '10px'}":width='1000' >
          <MasterPage :title="dialogStatus">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        <div slot="title-toolbar">
            <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataDemo(2)"><Icon type="ios-download-outline"></Icon>导出模板</Button>&nbsp;
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="100">
           <Row>
                <Col span="24">
                  <FormItem label="课题名称:  "   class="label">
                    <Input v-model="formItem1.subName" readonly  size="large"  placeholder="请输入课题名称"></Input>
                </FormItem>
                </Col>
              </Row>
              
               <Row>
                <Col span="24">
                  <FormItem label="指导教师:  "   class="label">
                    <Input v-model="formItem1.teaName"  readonly size="large"  placeholder="请输入指导教师"></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="24">
                  <FormItem label="指导内容:  "   class="label">
                    <Input v-model="zhidao"  readonly size="large"  placeholder="请输入内容指导"></Input>
                </FormItem>
                </Col>
              </Row>
              
             <Row>
                <Col span="24">
                  <FormItem label="指导内容:  "    class="label">
                    <Input v-model="formItem1.progContent"  type="textarea" :autosize="{minRows: 10,maxRows: 20}" size="large"  placeholder="请输入内容指导"></Input>
                </FormItem>
                </Col>
              </Row>
          </Form>
        </div>
       </div>
         
        </MasterPage>
    </Modal>
    <Modal v-model="modal12"   closable @on-ok='add' :styles="{top: '10px'}":width='1000' >
       <MasterPage :title="dialogStatus">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        <div slot="title-toolbar">
            <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataDemo(2)"><Icon type="ios-download-outline"></Icon>导出模板</Button>&nbsp;
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="100">
           <Row>
                <Col span="24">
                  <FormItem label="课题名称:  "   class="label">
                    <Input v-model="formItem1.subName" readonly  size="large"  placeholder="请输入课题名称"></Input>
                </FormItem>
                </Col>
              </Row>
              
               <Row>
                <Col span="24">
                  <FormItem label="指导教师:  "   class="label">
                    <Input v-model="formItem1.teaName"  readonly size="large"  placeholder="请输入指导教师"></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="24">
                  <FormItem label="指导方式:  "   class="label">
                    <Input v-model="zhidao"  readonly size="large"  placeholder="请输入内容指导"></Input>
                </FormItem>
                </Col>
              </Row>
              
             <Row>
                <Col span="24">
                  <FormItem label="指导内容:  "    class="label">
                    <Input v-model="formItem1.progContent"  type="textarea" :autosize="{minRows: 10,maxRows: 20}" size="large"  placeholder="请输入内容指导"></Input>
                </FormItem>
                </Col>
              </Row>
          </Form>
        </div>
       </div>
         
        </MasterPage>
    </Modal>
    
    
    
     
  
  
</section>



 
</template>
<script>
import MasterPage from '@/components/Master'
export default {
    components:{
        MasterPage,
    },
    data(){
      
      return{
          zhidao:'面授',
             modal11: false,
              modal12: false,
            dialogStatus: '',//title自定义标题
          value3: false,
                styles: {
                    height: 'calc(100% - 55px)',
                    overflow: 'auto',
                    paddingBottom: '53px',
                    position: 'static'
                },
                progContent:'',
                formData: {
                    id: '',
                    progContent: '',
                    progContentTime: '',
                    progReply: '',
                    progReplyTime: '',
                    progressSubId: '',
                },
                formItem1: {   
                    id:'',
                    progContent: '',
                    subName:'',
                    teaName:'',  
                    progressSubId:'',
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
            progContent: '',
            progContentTime: '',
            progReply: '',
            progReplyTime: '',
            progressSubId: '',
        },
        columns2: [
           
            
            {
                 title: '序号',
                type: 'index',
                width: 100,
                fixed: 'left',
                sortable: true
            },
            {
                title: '内容',
                key: 'progContent',
                minWidth: 100,
            },
            {
                title: '创建时间',
                key: 'progContentTime',
                minWidth: 100,
            },
            // {
            //     title: '导师回复',
            //     key: 'progReply',
            //     minWidth: 100,
            // }, 
            {
                title: '回复时间',
                key: 'progReplyTime',
                minWidth: 100,
            },
            {
                title: '课题id',
                key: 'progressSubId',
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
                                     
                                    },
                                     attrs:{
                                        title:'修改'
                                    },
                                      on: {
                                        click: () => {
                                        this.select(params.row)             //编辑方法
                                        }
                                      }
                                },'修改')
                            ]);
                        }
                    }
        ]
      }
    },
  
     created(){
        this.getData(1,10);
         this.getSubject()
     },
    methods:{
         getSubject(){
           let subId = localStorage.getItem("subId") 
           console.log(subId)
            this.$axios({     
                          url: 'sub/listOfChoice',
                            method: 'get',//请求的方式
                            params:{
                                stuId:localStorage.getItem("userId") 
                            },
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                         let list = res.data.data.beanList[0];
                         this.formItem1.subName=list.subName
                         this.formItem1.teaName=list.teacher.teaName
                         this.formItem1.progressSubId = list.subId
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                        this.getUser()
                      
        },
        add(){
            
            this.$axios({     
                            url: 'progress/add',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify(this.formItem1),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                        this.getData(1,10)
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                        this.$Modal.remove()
        },
        doReset(){
          this.formItem.progContent=''
           this.$Modal.remove()
        },
         select(row){

           this.formItem1.progContent = row.progContent
             this.formItem1.id = row.id

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
            console.log
         
            this.$axios({     
                            url: 'progress/update',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify(this.formItem1),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                        this.getData(1,10)
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                       this.formItem1.progContent =''
        
        },
        delById(row) {
            this.$Modal.confirm({
                title: "确认删除",
                content: "您确认要删除?",
                onOk: () => {
                    console.log(row)
                 this.$axios({     
                            url: 'progress/delete/' + row.id,
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
                            url: 'progress/add',
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
                            url: 'progress/update',
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
        let userId = localStorage.getItem("userId") 
        let params = this.formItem
        
       let  token = localStorage.getItem('token')
         this.$axios({
                            
                           url: 'progress/listOfStu?stuId=' + userId + '&page=' + page + '&pageSize=' + pageSize,
                           method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                            if(item.progReplyTime==null){
                              item.progReplyTime='未回复'
                            }
                           this.tableData.push({
                            id: item.id,
                            progContent:item.progContent,
                            progContentTime: item.progContentTime,
                            progReply: item.progReply,
                            progReplyTime: item.progReplyTime,
                            progressSubId: item.progressSubId,
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
        this.formData.id = ''
        this.formData.progContent = ''
        this.formData.progContentTime = ''
        this.formData.progReply = ''
        this.formData.progReplyTime = ''
        this.formData.progressSubId = ''
        this.dialogStatus = '新增';//对应标题
        this.value3 = true
        
        // this.getData();
        // this.resetFormColumns();//重置
      },
      handleRender1 () {
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
                            url: 'progress/deleteAll',
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
        this.formItem.id = ''
        this.formItem.progContent = ''
        this.formItem.progContentTime = ''
        this.formItem.progReply = ''
        this.formItem.progReplyTime = ''
        this.formItem.progressSubId = ''
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