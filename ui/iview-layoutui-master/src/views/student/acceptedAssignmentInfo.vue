<style lang="postcss" scoped>
.label > :first-child{
  font-size: 15px;
  float: none;
    width: 1000%;
    border-radius: 2px;
    -webkit-box-sizing: border-box!important;
    -moz-box-sizing: border-box!important;
    box-sizing: border-box!important;
    text-align: left;
    
}
.home-container{

}
</style>
<template>
<section class="home-container">
    <MasterPage title="任务书信息">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        <div slot="title-toolbar">
            <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataDemo()"><Icon type="ios-download-outline"></Icon>导出模板</Button>&nbsp;
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width=0>
             <Row>
                <Col span="24">
                  <FormItem  span="24" label="一、主要内容:  "    class="label">
                    
                    <Input v-model="formItem.taskContent" readonly type="textarea" :autosize="{minRows: 4,maxRows: 10}" size="large"  placeholder="请输入主要内容"></Input>
                </FormItem>
                </Col>
              </Row>
              <Row>
                <Col span="24">
                  <FormItem label="二、基本要求:  "    class="label">
                    <Input v-model="formItem.taskRequire" readonly type="textarea" :autosize="{minRows: 4,maxRows: 10}" size="large"  placeholder="请输入基本要求 "></Input>
                </FormItem>
                </Col>
              </Row>
                <Row>
                <Col span="24">
                  <FormItem label="三、工作进度安排:  "    class="label">
                    <Input v-model="formItem.taskSchedule" readonly type="textarea" :autosize="{minRows: 4,maxRows: 10}" size="large"  placeholder="请输入工作进度安排"></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="24">
                  <FormItem label="四、应收集资料及主要参考文献:  "    class="label">
                    <Input v-model="formItem.taskLiterature" readonly type="textarea" :autosize="{minRows: 4,maxRows: 10}" size="large"  placeholder="请输入应收集资料及主要参考文献"></Input>
                </FormItem>
                </Col>
              </Row>
          </Form>
        </div>
       </div>
        
    </MasterPage>
      
      <MasterPage title="审核信息">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        
        <div slot="paddingContent">
         <Table :columns="columns1"  stripe   border  :data="tableData"></Table>
        </div>
        
       
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
        tableData:[],
        id:'',
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
         columns1: [
          {
                title: '操作人',
                key: 'student',
                width: 400,
                minWidth: 100,
            },
            {
                title: '操作时间',
                key: 'firstReportDeadline',
                minWidth: 150,
            },
            {
                title: '状态',
                key: 'subStuState',
                minWidth: 150,
            },
            {
                title: '意见',
                key: 'yijian',
                minWidth: 150,
            },    
        ],
       
      }
    },
     created(){
       this.getData()
     },
    methods:{
     
       getData(){
         let userId = localStorage.getItem("userId") 
        let  token = localStorage.getItem('token')
         this.formItem.id =  localStorage.getItem('taskId')
        let params = this.formItem
         this.$axios({
                            
                            url: 'task/list',
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList[0];
                          
                          
                              this.formItem.id = list.id,
                              this.formItem.taskFile =list.taskFile,
                              this.formItem.taskState = list.taskState,
                              this.formItem.taskNumber = list.taskNumber,
                              this.formItem.taskSubName = list.subject.subName,
                              this.formItem.teaName= list.subject.teacher.teaName,
                              this.formItem.stuName= list.subject.student.stuName,
                              this.formItem.stuClass= list.subject.student.stuClass,
                              this.formItem.replyFile = list.replyFile,
                              this.formItem.taskTime = list.taskTime,
                              this.formItem.replyTime = list.replyTime,
                              this.formItem.taskContent = list.taskContent,
                              this.formItem.taskRequire = list.taskRequire,
                              this.formItem.taskSchedule = list.taskSchedule,
                              this.formItem.taskLiterature = list.taskLiterature,
                              this.formItem.replyContent = list.replyContent,
                              this.formItem.subject = list.subject
                              this.tableData.push({
                                  student: this.formItem.stuName,
                                  firstReportDeadline:list.subject.firstReportDeadline,
                                  subStuState:list.subject.firstReportDeadline,
                                  yijian:''
                                })
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
      },
       update(){
          console.log(this.formItem)
            this.$axios({     
                            url: 'stu/update',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify(this.formItem),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                        
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                        this.getUser()
                      
        },
        exportDataDemo(){
          let taskId =  localStorage.getItem('taskId')
          let url="http://localhost:8080/task/export?primaryKey=" + taskId
          window.open(url) 
        },
       

    }
}
</script>


