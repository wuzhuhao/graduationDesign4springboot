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
            <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataDemo()"><Icon type="ios-download-outline"></Icon>导出报告</Button>&nbsp;
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width=0>
             <Row>
                <Col span="24">
                  <FormItem  span="24" label="开题申请：（包括选题的意义与目的、文献综述、研究现状、创新思路、论文提纲、参考文献等。如果篇幅不够，可另加页。字数不少于1500字。）"    class="label">
                    
                    <Input v-model="formItem.reportContent" readonly type="textarea" :autosize="{minRows: 10,maxRows: 50}" size="large"  placeholder="Enter something..."></Input>
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
         columns1: [
            {
              title: '序号',
              type: 'index',
              width: 150,
              fixed: 'left',
              align: 'center'
            }, 
          {
                title: '操作人',
                key: 'teaName',
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
                key: 'teaSuggestion',
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
        let params = this.formItem
        let userId = localStorage.getItem("userId") 
       let  token = localStorage.getItem('token')
         this.$axios({
                            
                           url: 'report/listOfStu',
                            method: 'get',//请求的方式
                            params:{
                            
                              stuId:userId,
                              reportType:1
                            },
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList[0];
                              this.formItem.reportSubId = list.reportSubId,
                              this.formItem.reportType = list.reportType,
                              this.formItem.id = list.id,
                              this.formItem.reportState = list.reportState,
                              this.formItem.reportSubtime = list.reportSubtime,
                              this.formItem.reportVersion = list.reportVersion,
                              this.formItem.reportFile = list.reportFile,
                              this.formItem.reportTemp = list.reportTemp,
                              this.formItem.reportContent = list.reportContent,
                              this.formItem.stuMessage = list.stuMessage,
                              this.formItem.teaSuggestion = list.teaSuggestion,
                              this.formItem.subject = list.subject,
                              this.formItem.subName =list.subject.subName,
                              this.formItem.teaName =list.subject.teacher.teaName,
                              this.formItem.stuName =list.subject.student.stuName
                               this.formItem.teaSuggestion=list.teaSuggestion
                              this.tableData.push({
                                  teaName: this.formItem.teaName,
                                  firstReportDeadline:list.subject.firstReportDeadline,
                                  subStuState:list.subject.firstReportDeadline,
                                  teaSuggestion:list.teaSuggestion
                                })
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
      },
      exportDataDemo(){
            var url="http://localhost:8080/report/export?type=1&subId=" + this.formItem.reportSubId
            window.open(url) 
        
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
                      
        }
       

    }
}
</script>


