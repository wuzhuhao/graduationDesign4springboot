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
                  <FormItem label="学生姓名">
                    <Input v-model="formItem.stuName" placeholder="请输入学生姓名"></Input>
                </FormItem>
                </Col>
                <Col span="8">
                  <FormItem label="课题名称">
                    <Input v-model="formItem.subName" placeholder="请输入课题名称"></Input>
                </FormItem>
                </Col>
                
                 
              </Row>
          </Form>
        </div>
        <div slot="search">
            
          <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doSearch">查询</Button>  &nbsp; &nbsp; &nbsp; &nbsp;
           <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doReset">重置</Button>  &nbsp;
          <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataReport(1)"><Icon type="ios-download-outline"></Icon>导出开题报告</Button>&nbsp;
          <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataTask()"><Icon type="ios-download-outline"></Icon>导出任务书</Button>&nbsp;
           <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataReport(2)"><Icon type="ios-download-outline"></Icon>导出论文</Button>&nbsp; 
           <Button type="info"  style="float:left;margin:0 8px"  @click="exportData(1)"><Icon type="ios-download-outline"></Icon>导出周进展</Button>&nbsp;
        </div>
        <div slot="btns">
          <Button type="primary" icon="md-add" @click="handleCreate">添加</Button>
        </div>
        <div slot="paddingContent">
          <Table border  :columns="columns2" :data="tableData" border   @on-selection-change="changeSelect" ref="table"></Table>
        </div>
       
        
        <div slot="pager">
            <Page :total="this.pagination.total"  :page-size="this.pagination.pageSize"  :page-size-opts="this.pagination.pageSizeOpts" 
            :current="this.pagination.currentPage"  show-total  />
        </div>    

    </MasterPage>


  
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
                  teaId:'',
                subName:'',
                stuName:'',
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
        columns2: [
            
             {
               type: 'selection',
               width: 60,
               align: 'center',
              fixed: 'left'
             },
            {
                title: '序号',
                type: 'index',
                width: 100,
                fixed: 'left',
                sortable: true
            },
            {
                title: '学生名称',
                key: 'stuName',
                minWidth: 100,
            },
            {
                title: '课题名称',
                key: 'subName',
                minWidth: 100,
            }, {
                title: '指导教师',
                key: 'teaName',
                minWidth: 100,
            },
            {
                title: '专业名称',
                key: 'stuMajor',
                minWidth: 100,
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
        let  userId = localStorage.getItem('userId')
       this.formItem.teaId = userId
         this.$axios({
                            
                            // url: 'sub/listScheduleOfTea?page=' + page  + '&pageSize=' + pageSize,
                            url:'sub/listScheduleOfTea?isJoinStudent=true&isJoinTeacher=true&isJoinTask=true&isJoinReport=true&isJoinScoreRecord=true',
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                           let firstReportStateString= '未完成';
                           let finalReportStateString= '未完成';
                           let taskStateString= '已完成';
                           let subStateString= '已完成';
                          list.forEach((item, index) => {
                              if(item.reportList.reportType===1&&item.reportList.reportState===4){
                                        firstReportStateString = '已完成'
                              }else if(item.reportList.reportType===2&&item.reportList.reportState===4){
                                        finalReportStateString = '已完成'
                              }else if(item.reportList.reportState===4){
                                   taskStateString  = '已完成'
                               }else if(item.taskList.subStuState===3){
                                   tsubStateString = '已完成'
                               }
                            console.log(firstReportStateString)
                            console.log(finalReportStateString)
                            console.log(taskStateString)
                            console.log(subStateString)
                           this.tableData.push({
                               taskStateString:taskStateString,
                               subStuState:subStateString,
                                replyState:item.replyState,
                                firstReportState:firstReportStateString,
                                finalReportState:firstReportStateString,
                                stuId:item.stuId,
                                stuMajor: item.stuMajor,
                                stuName:item.stuName,
                                subId:item.subId,
                                subName: item.subName,
                                taskList: item.taskList,
                                teaId: item.teaId,
                                teaName: item.teaName
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
        this.formItem.teaId = ''
        this.formItem.teaPassword = ''
        this.formItem.teaName = ''
        this.formItem.teaSex = ''
        this.formItem.teaAge = ''
        this.formItem.teaBirthday = ''
        this.formItem.teaPhone = ''
        this.formItem.teaMail = ''
        this.formItem.teaAddress = ''
        this.formItem.teaRemarks = ''
    },
     handleSummary ({ columns, data }) {
          console.log(columns)
        
                const sums = {};
                var i = 0
                var j = 0
                var k = 0
                columns.forEach((column, index) => {
                    i++
                    const key = column.key;
                    if (index === 0) {
                        sums[key] = {
                            key,
                            value: '完成人数'
                        };
                        return;
                    }
                    const values = data.map(item => String(item[key]));
                    console.log(values)
                    for( k =0; k < values.length;k++){
                        if(values[k]=='已完成'){
                            j++
                        }
                    }
                    if(i>5){
                       
                        sums[key] = {
                            key,
                            value: '完成(' +j + ')'
                        };
                        j=0
                    }else{
                        sums[key] = {
                            key,
                            value: ''
                        };
                    }
                    
                });
               
                return sums;
            },
    check(str){
        return str.search('完成')!=-1
    },
    exportDataTask(){
     var url="http://localhost:8080/task/export?primaryKey="+ this.selectList[0].taskList[0].taskId
           console.log( url)
           window.open(url) 
    },
    exportDataReport(type){
       console.log( this.selectList)
           var url="http://localhost:8080/report/export?type=" + type+ "&subId=" + this.selectList[0].subId
           console.log( url)
           window.open(url) 

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