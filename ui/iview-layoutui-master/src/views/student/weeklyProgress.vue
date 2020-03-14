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
                        <FormItem label="id" label-position="top">
                            <Input v-model="formData.id" placeholder="please enter user name" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="内容" label-position="top">
                            <Input v-model="formData.progContent" placeholder="please enter url">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="创建时间" label-position="top">
                            <Input v-model="formData.progContentTime" placeholder="please enter user name" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="回复内容" label-position="top">
                            <Input v-model="formData.progReply" placeholder="please enter url">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="回复时间" label-position="top">
                            <Input v-model="formData.progReplyTime" placeholder="please enter user name" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="课题id" label-position="top">
                            <Input v-model="formData.progressSubId" placeholder="please enter url">
                            </Input>
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
                    id: '',
                    progContent: '',
                    progContentTime: '',
                    progReply: '',
                    progReplyTime: '',
                    progressSubId: '',
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
               type: 'selection',
               width: 60,
               align: 'center',
              fixed: 'left'
             },
            
            {
                title: 'id',
                key: 'id',
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
            {
                title: '导师回复',
                key: 'progReply',
                minWidth: 100,
            }, {
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
            this.formData.id = row.id
            this.formData.progContent = row.progContent
            this.formData.progContentTime =  row.progContentTime
            this.formData.progReply =  row.progReply
            this.formData.progReplyTime =  row.progReplyTime
            this.formData.progressSubId =  row.progressSubId
            this.value3 = true
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
                            
                            url: 'progress/list?page=' + page  + '&pageSize=' + pageSize,
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
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