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
                  <FormItem label="操作人：">
                    <Input v-model="formItem.operaRole" placeholder="请输入操作人"></Input>
                </FormItem>
                </Col>
                <Col span="8">
                  <FormItem label="内容：">
                    <Input v-model="formItem.operaContent" placeholder="请输入内容"></Input>
                </FormItem>
                </Col>
                
                 
              </Row>
          </Form>
        </div>
        <div slot="search">
            
          <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doSearch">查询</Button>  &nbsp; &nbsp; &nbsp; &nbsp;
           <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doReset">重置</Button>  &nbsp;
         
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
                    <Col span="12">
                        <FormItem label="id：" label-position="top">
                            <Input v-model="formData.teaId" placeholder="请输入id" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="密码：" label-position="top">
                            <Input v-model="formData.teaPassword" placeholder="请输入密码">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="名称：" label-position="top">
                            <Input v-model="formData.teaName" placeholder="请输入名称" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="性别：" label-position="top">
                            <Input v-model="formData.teaSex" placeholder="请输入性别">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="年龄：" label-position="top">
                            <Input v-model="formData.teaAge" placeholder="请输入年龄" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="生日：" label-position="top">
                            <Input v-model="formData.teaBirthday" placeholder="请输入生日">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="电话：" label-position="top">
                            <Input v-model="formData.teaPhone" placeholder="请输入电话" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="邮箱：" label-position="top">
                            <Input v-model="formData.teaMail" placeholder="请输入邮箱">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="地址：" label-position="top">
                            <Input v-model="formData.teaAddress" placeholder="请输入地址" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="备注：" label-position="top">
                            <Input v-model="formData.teaRemarks" placeholder="请输入备注">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="学院id：" label-position="top">
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
                    teaId: '',
                    teaPassword: '',
                    teaName: '',
                    teaSex: '',
                    teaAge: '',
                    teaBirthday: '',
                    teaPhone: '',
                    teaMail: '',
                    teaAddress: '',
                    teaRemarks: '',
                    academyId: '',
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
            operaRole:'',
            operaContent:'',
             operaTime:'',
        },
        columns2: [
           
            
            {
                title: 'id',
                key: 'id',
                width: 100,
                fixed: 'left',
                sortable: true
            },
            {
                title: '操作人',
                key: 'operaRole',
                windth:100,
                minWidth: 100,
            },
            {
                title: '操作内容',
                key: 'operaContent',
                minWidth: 300,
                tooltip:true,  
              render: (h, params) => {
                    let texts = params.row.operaContent.title;//表格列显示文字
                   
                    return h('div', [
                        h('Tooltip', {
                                props: {
                                    placement: 'top',
                                    transfer: true
                                }
                            }, [//这个中括号表示是Tooltip标签的子标签
                                texts,//表格列显示文字
                                h('div', {
                                    slot: 'content',
                                    style: {
                                        whiteSpace: 'normal'
                                    }
                                }, JSON.stringify(params.row.operaContent))//整个的信息即气泡内文字
                                ])
                    ]);
            }

                


            }, {
                title: '操作时间',
                key: 'operaTime',
                windth:200,
                minWidth: 150,
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
            this.formData.teaId = row.teaId
            this.formData.teaPassword = row.teaPassword
            this.formData.teaName =  row.teaName
            this.formData.teaSex =  row.teaSex
            this.formData.teaAge =  row.teaAge
            this.formData.teaBirthday =  row.teaBirthday
            this.formData.teaPhone = row.teaPhone
            this.formData.teaMail =  row.teaMail
            this.formData.teaAddress =  row.teaAddress
            this.formData.teaRemarks =  row.teaRemarks
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
                            url: 'tea/delete/' + row.teaId,
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
      update(){
          console.log(this.formData)
        if(this.dialogStatus == '新增'){
            this.$axios({     
                            url: 'tea/add',
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
                            url: 'tea/update',
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
                            
                            url: 'operation/list?page=' + page  + '&pageSize=' + pageSize,
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
                              operaRole: item.operaRole,
                              operaContent:item.operaContent,
                              operaTime: item.operaTime,
                            
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
        this.formData.teaId = ''
        this.formData.teaPassword = ''
        this.formData.teaName = ''
        this.formData.teaSex = ''
        this.formData.teaAge = ''
        this.formData.teaBirthday = ''
        this.formData.teaPhone = ''
        this.formData.teaMail = ''
        this.formData.teaAddress = ''
        this.formData.teaRemarks = ''
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
		lstprimaryKey.push(this.selectList[i].teaId)
	}
     console.log(lstprimaryKey)
      this.$Modal.confirm({
        title: "确认删除",
        content: "您确认要删除所选的 " + this.selectCount + " 条数据?",
        onOk: () => {
           this.$axios({     
                            url: 'tea/deleteAll',
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
      doReset(){
        this.formItemid= '',
        this.formItemoperaRole='',
        this.formItemoperaContent='',
        this.formItemoperaTime='',
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