<style lang="postcss" scoped>
.home-container{

}
</style>
<template>
<section class="home-container">
    <MasterPage :title="title">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        <div slot="title-toolbar">
            <Button type="primary"   @click="reload1">返回字典首页</Button>
        </div>

        <!-- 条件搜索 -->
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="80">
              <Row>
               
                <Col span="8">
                  <FormItem label="字典描述">
                    <Input v-model="formItem.dictDescription" placeholder="字典描述"></Input>
                </FormItem>
                </Col>
              
                 
              </Row>
          </Form>
        </div>
        <div slot="search">
            
          <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doSearch">查询</Button>  &nbsp; &nbsp; &nbsp; &nbsp;
           <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doReset">重置</Button>  &nbsp;
          <Button type="info"  style="float:left;margin:0 8px"  @click="exportData(1)"><Icon type="ios-download-outline"></Icon>导出数据</Button>&nbsp;
    
        </div>
        <div slot="btns">
          <Button type="primary" icon="md-add" @click="handleCreate">添加</Button>
        </div>
        <div slot="paddingContent">
          <Table border   :columns="columns" :data="tableData"  @on-selection-change="changeSelect" ref="table"></Table>
        </div>
        <div slot="pager">
            <Page :total="this.pagination.total"  :page-size="this.pagination.pageSize"  :page-size-opts="this.pagination.pageSizeOpts" 
            :current="this.pagination.currentPage"  @on-change="pageChange" @on-page-size-change="pageSizeChange"  show-elevator show-total show-sizer />
        </div>    

    </MasterPage>
  
<Modal v-model="modal1"   closable @on-ok='updateModel()' :styles="{top: '30%'}":width='700' >
       <MasterPage :title="dialogStatus">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="100">
           <Row>
                <Col span="24">
                  <FormItem :label="dictValueLabel"   class="label">
                    <Input v-model="formData.dictValue"   size="large"  placeholder="请输入课题名称"></Input>
                </FormItem>
                </Col>
              </Row>
              <Row  v-show="dictShow"> 
                <Col span="24">
                  <FormItem label="value"   class="label">
                    <Input v-model="formData.dictText"   size="large"  placeholder="请输入指导教师"></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="24">
                  <FormItem :label="dictDescriptionLabel"   class="label">
                    <Input v-model="formData.dictDescription"   size="large"  placeholder="请输入指导教师"></Input>
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
        MasterPage
    },
    data(){
      
      return{
        dictValueLabel:'',
        dictTextLabel:'',
        dictDescriptionLabel:'',
        modal1:false,
        dictShow:false,
          isRouterShow:true,
            dialogStatus: '',//title自定义标题
            title:'系统字典',
          value3: false,
                styles: {
                    height: 'calc(100% - 55px)',
                    overflow: 'auto',
                    paddingBottom: '53px',
                    position: 'static'
                },
                formData: {
                    dictDescription: '',
                    dictParentid: '',
                    dictText: '',
                    dictType:'model',
                    dictValue:'',
                    id: '',
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
            dictDescription: '',
            dictParentid: '',
            dictText: '',
            dictType:'model',
            dictValue:'',
            id: '',
        },
        columns:[],
        columns1: [
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
                title: 'key',
                key: 'dictText',
                minWidth: 100,
            },
             {
                title: 'value',
                key: 'dictValue',
                minWidth: 100,
            },
            {
                title: '值描述',
                key: 'dictDescription',
                minWidth: 100,
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
                                }),
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
        ],
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
                title: '实体类',
                key: 'dictValue',
                minWidth: 100,
            },
            {
                title: '实体类描述',
                key: 'dictDescription',
                minWidth: 400,
            },{
                        title: '操作',
                        key: 'action',
                        fixed: 'right',
                         width: 150,
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'text',
                                        size: 'small',
                                        icon:'icon iconfont icon-xiangqing'
                                    },
                                     attrs:{
                                        title:'查询'
                                    }, style: {
                                        marginRight: '5px'
                                        },
                                      on: {
                                        click: () => {
                                        this.Info(params.row)             //编辑方法
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
                                }),
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
        ],
          columns3: [
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
                title: '字典名称',
                key: 'dictValue',
                minWidth: 100,
            },
            {
                title: '字典描述',
                key: 'dictDescription',
                minWidth: 400,
            },{
                        title: '操作',
                        key: 'action',
                        fixed: 'right',
                         width: 150,
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'text',
                                        size: 'small',
                                        icon:'icon iconfont icon-xiangqing'
                                    },
                                     attrs:{
                                        title:'查询'
                                    }, style: {
                                        marginRight: '5px'
                                        },
                                      on: {
                                        click: () => {
                                        this.Info(params.row)             //编辑方法
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
                                }),
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
         this.columns = this.columns2
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
             Info (row) {
                 console.log(row.dictType=== 'model')
                if (row.dictType === 'model') {
                  this.formItem.dictDescription=''
                    this.formItem.dictType='item'
                    this.formItem.dictParentid = row.id;
                   this.formData.dictType= 'item'
                   this.formData.dictParentid = row.id;
                   this.title = '实体类详情'
                    this.columns = this.columns3
                } else if (row.dictType === 'item') {
                   this.formItem.dictDescription='';
                  this.dictShow=true
                     this.formItem.dictType='dict'
                      this.formItem.dictParentid = row.id;
                   this.formData.dictType= 'dict'
                   this.formData.dictParentid = row.id;
                   this.title = '字典详情'
                    console.log(this.formData.dictParentid)
                   this.columns = this.columns1
                }else{
                    //  this.formItem.dictType='dict'
                    //  this.formItem.dictParentid = row.id;
                    //  this.title = '字典详情'
                    // this.formData.dictType= 'dict'
                    //  this.formData.dictParentid = row.id;
                    
                    // this.columns = this.columns2
                }
                this.getData(1,10)
            } ,
      
      // watch: {
      //   // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
      //     '$route': 'getParams'
      // },
      //编辑
      edit(row){
            this.dialogStatus = '编辑';//对应标题
           if( this.formItem.dictType=='model'){
                this.dictValueLabel = '实体类名：'
                this.dictDescriptionLabel = '实体类描述：'
            }else if( this.formItem.dictType=='item'){
                this.dictValueLabel = '字典名称:'
                this.dictDescriptionLabel = '字典描述:'
               
            }else{
                this.dictValueLabel = 'key:'
                this.dictDescriptionLabel = '值描述:'
            }
             this.formData.dictDescription= row.dictDescription
            this.formData.dictParentid= row.dictParentid
            this.formData.dictText= row.dictText
            this.formData.dictType=row.dictType
            this.formData.dictValue=row.dictValue
            this.formData.id= row.id
            this.modal1 = true
        },
        delById(row) {
            this.$Modal.confirm({
                title: "确认删除",
                content: "您确认要删除?",
                onOk: () => {
                    console.log(row)
                 this.$axios({     
                            url: 'sysdict/delete/' + row.id,
                            method: 'get',//请求的方式
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
      updateModel(){
          console.log(this.formData)
        if(this.dialogStatus == '新增'){
            this.$axios({     
                            url: 'sysdict/add',
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
                            url: 'sysdict/update',
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
                            
                            url: 'sysdict/list?page=' + page  + '&pageSize=' + pageSize ,
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                           this.tableData.push({
                                dictDescription: item.dictDescription,
                                dictParentid: item.dictParentid,
                                dictText: item.dictText,
                                dictType:item.dictType,
                                dictValue:item.dictValue,
                                id: item.id,
                           })
                          })
                  
                           this.pagination.total =res.data.data.totalRecord
                           this.pagination.currentPage =res.data.data.currentPage
                          
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                        console.log(this.tableData)
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
           if( this.formItem.dictType=='model'){
                this.formData.dictType='model',
                this.dictValueLabel = '实体类名：'
                this.dictDescriptionLabel = '实体类描述：'
                this.dictShow = false
            }else if( this.formItem.dictType=='item'){
                 this.formData.dictType='item',
                this.dictValueLabel = '字典名称:'
                this.dictDescriptionLabel = '字典描述:'
                 this.dictShow = false
            }else{
                 this.formData.dictType='dict',
                this.dictValueLabel = 'key:'
                this.dictDescriptionLabel = '值描述:'
                this.dictShow = true
            }
        this.formData.dictDescription= '',
        this.formData.id= '',
        this.formData.dictText= '',
       
        this.formData.dictValue='',
        console.log(this.formData.id + 666)
        this.dialogStatus = '新增';//对应标题
        this.modal1 = true
        
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
                            url: 'sysdict/deleteAll',
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
      reload1 (){
           this.title = '系统字典'
       this.doReset();
       this.getData(1,10)
       this.columns = this.columns2
    },
      doReset(){
          this.title = '系统字典'
            this.formItem.dictDescription='',
            this.formItem.dictParentid='',
            this.formItem.dictText='',
            this.formItem.dictType='model',
            this.formItem.dictValue='',
            this.formItem.id=''
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