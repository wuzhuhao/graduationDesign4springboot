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
                    <Input v-model="formItem.adminId" placeholder="请输入id"></Input>
                </FormItem>
                </Col>
                <Col span="8">
                  <FormItem label="姓名：">
                    <Input v-model="formItem.adminName" placeholder="请输入姓名"></Input>
                </FormItem>
                </Col>
                <Col span="8">
                  <FormItem label="身份：">
                    <Select v-model="formItem.adminType">
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
        <Upload action="http://47.100.136.105:8080/uploadFile/importUserByExcel?type=3"    style="float:left;margin:0 8px">
            <Button  type="info" icon="ios-cloud-upload-outline">批量注册</Button>
        </Upload>
         <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataDemo(3)"><Icon type="ios-download-outline"></Icon>导出注册模板</Button>&nbsp;
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
                    <Col span="12">
                        <FormItem label="id：" label-position="top">
                            <Input v-model="formData.adminId" placeholder="请输入id" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="密码：" label-position="top">
                            <Input v-model="formData.adminPassword" placeholder="请输入密码">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row :gutter="32">
                    <Col span="12">
                        <FormItem label="名称：" label-position="top">
                            <Input v-model="formData.adminName" placeholder="请输入名称" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="性别：" label-position="top">
                            <Input v-model="formData.adminSex" placeholder="请输入性别">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="年龄：" label-position="top">
                            <Input v-model="formData.adminAge" placeholder="请输入年龄" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="生日：" label-position="top">
                            <Input v-model="formData.adminBirthday" placeholder="请输入生日">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="电话：" label-position="top">
                            <Input v-model="formData.adminPhone" placeholder="请输入电话" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="邮箱：" label-position="top">
                            <Input v-model="formData.adminMail" placeholder="请输入邮箱">
                            </Input>
                        </FormItem>
                    </Col>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="地址：" label-position="top">
                            <Input v-model="formData.adminAddress" placeholder="请输入地址" />
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="备注：" label-position="top">
                            <Input v-model="formData.adminRemarks" placeholder="请输入备注">
                            </Input>
                        </FormItem>
                    </Col>
                </Row>
                </Row><Row :gutter="32">
                    <Col span="12">
                        <FormItem label="身份：" label-position="top">
                            <Input v-model="formData.adminType" placeholder="请输入身份" />
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
                  adminId:'',
                  adminPassword:'',
                  adminName:'',
                  adminSex:'',
                  adminAge:'',
                  adminBirthday:'',
                  adminPhone:'',
                  adminMail:'',
                  adminAddress:'',
                  adminRemarks:'',
                  adminType:''
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
          adminId:'',
          adminPassword:'',
          adminName:'',
          adminSex:'',
          adminAge:'',
          adminBirthday:'',
          adminPhone:'',
          adminMail:'',
          adminAddress:'',
          adminRemarks:'',
          adminType:''
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
                key: 'adminId',
                width: 100,
                fixed: 'left',
                sortable: true
            },
            {
                title: '密码',
                key: 'adminPassword',
                minWidth: 100,
            },
            {
                title: '名称',
                key: 'adminName',
                minWidth: 100,
            }, {
                title: '性别',
                key: 'adminSex',
                minWidth: 100,
            },
            {
                title: '年龄',
                key: 'adminAge',
                minWidth: 100,
            },
            {
                title: '生日',
                key: 'adminBirthday',
                minWidth: 100,
            } ,
            {
                title: '电话',
                key: 'adminPhone',
                minWidth: 100,
            },
            {
                title: '邮箱',
                key: 'adminMail',
                minWidth: 100,
            },
            {
                title: '地址',
                key: 'adminAddress',
                minWidth: 100,
            }, {
                title: '备注',
                key: 'adminRemarks',
                minWidth: 100,
            },
            {
                title: '身份',
                key: 'adminType',
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
                                    style: {
                                        marginRight: '5px'
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
            this.formData.adminId = row.adminId
            this.formData.adminPassword = row.adminPassword
            this.formData.adminName =  row.adminName
            this.formData.adminSex =  row.adminSex
            this.formData.adminAge =  row.adminAge
            this.formData.adminAge =  row.adminAge
            this.formData.adminBirthday = row.adminBirthday
            this.formData.adminPhone =  row.adminPhone
            this.formData.adminMail =  row.adminMail
            this.formData.adminAddress =  row.adminAddress
            this.formData.adminRemarks =  row.adminRemarks
            this.formData.adminType =  row.adminType
            this.value3 = true
        },
        delById(row) {
            this.$Modal.confirm({
                title: "确认删除",
                content: "您确认要删除?",
                onOk: () => {
                    console.log(row)
                 this.$axios({     
                            url: 'admin/delete/' + row.adminId,
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
                            url: 'admin/add',
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
                            url: 'admin/update',
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
                            
                            url: 'admin/list?page=' + page  + '&pageSize=' + pageSize,
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                           this.tableData.push({
                              adminId: item.adminId,
                              adminPassword: item.adminPassword,
                              adminName:item.adminName,
                              adminSex: item.adminSex,
                              adminAge: item.adminAge,
                              adminBirthday:item.adminBirthday,
                              adminPhone:item.adminPhone,
                              adminMail:item.adminMail,
                              adminAddress:item.adminAddress,
                              adminRemarks: item.adminRemarks,
                              adminType: item.adminType,
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
        this.formData.adminId = ''
        this.formData.adminPassword = ''
        this.formData.adminName = ''
        this.formData.adminSex = ''
        this.formData.adminAge = ''
        this.formData.adminBirthday = ''
        this.formData.adminPhone = ''
        this.formData.adminMail = ''
        this.formData.adminAddress = ''
        this.formData.adminRemarks = ''
        this.formData.adminType = ''
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
		lstprimaryKey.push(this.selectList[i].adminId)
	}
     console.log(lstprimaryKey)
      this.$Modal.confirm({
        title: "确认删除",
        content: "您确认要删除所选的 " + this.selectCount + " 条数据?",
        onOk: () => {
           this.$axios({     
                            url: 'admin/deleteAll',
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
        this.formItem.adminId = ''
        this.formItem.adminPassword = ''
        this.formItem.adminName = ''
        this.formItem.adminSex = ''
        this.formItem.adminAge = ''
        this.formItem.adminBirthday = ''
        this.formItem.adminPhone = ''
        this.formItem.adminMail = ''
        this.formItem.adminAddress = ''
        this.formItem.adminRemarks = ''
        this.formItem.adminType = ''
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