<style lang="postcss" scoped>
.label > :first-child{
  font-size: 15px;
}
.home-container{

}
</style>
<template>
<section class="home-container">
    <MasterPage title="课题信息">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
      
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="100">
           <Row>
                <Col span="24">
                  <FormItem label="选题学生:  "   class="label">
                    <Input v-model="formItem.student" readonly  size="large"  placeholder="请输入选题学生"></Input>
                </FormItem>
                </Col>
              </Row>
              
               <Row>
                <Col span="24">
                  <FormItem label="课题名称:  "   class="label">
                    <Input v-model="formItem.subName"  readonly size="large"  placeholder="请输入课题名称"></Input>
                </FormItem>
                </Col>
              </Row>
              
             <Row>
               <Col span="24">
               <FormItem label="题目性质:  "   class="label">
                  <RadioGroup v-model="formItem.subNature"  size="large">
                  <Radio :label="1"  disabled>理论性题目</Radio>
                  <Radio :label="2" disabled>实践性题目</Radio>            
            </RadioGroup>
            </FormItem>
             </Col>
              </Row>
               <Row>
               <Col span="24">
               <FormItem label="课题来源:  "    class="label">
                  <RadioGroup v-model="formItem.subSource" size="large">
                  <Radio :label='1'  disabled>企业项目</Radio>
                  <Radio :label='2' disabled>科研项目</Radio>
                  <Radio :label='3'  disabled>自拟题目</Radio>
                  
            </RadioGroup>
            </FormItem>
             </Col>
              </Row>
             <Row>
                <Col span="24">
                  <FormItem label="课题介绍:  "    class="label">
                    <Input v-model="formItem.subIntroduce" readonly type="textarea" :autosize="{minRows: 5,maxRows: 10}" size="large"  placeholder="请输入课题介绍"></Input>
                </FormItem>
                </Col>
              </Row>
          </Form>
        </div>
       </div>
        
    </MasterPage>
      <MasterPage title="用户信息">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="100">
             
               <Row>
                <Col span="24">
                  <FormItem label="课题申请人:  "   class="label">
                    <Input v-model="formItem.teacher"  readonly size="large"  placeholder="请输入课题申请人"></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="24">
                  <FormItem label="指导老师:  "   class="label">
                    <Input v-model="formItem.teacher"  readonly size="large"  placeholder="请输入指导老师"></Input>
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
          subId: '',
          subName: '',
          subNature: '',
          subSource: '',
          subTeaId: '',
          subFile:'',
          firstReportDeadline: '',
          lastReportDeadline:'',
          stuId:'',
          subStuState: '',
          subLastScore:'',
          showId:'',
          subIntroduce: '',
          student:'',
          teacher: '',
          designShow: '',
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
       this.getSubject()
     },
    methods:{
     
      getSubject(){
         let userId = localStorage.getItem("userId") 
         this.$axios({
                            // headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                            url: 'sub/listOfChoice',//请求的地址
                            method: 'get',//请求的方式
                             params: {stuId:userId},//请求的数据
                    }).then(res => {
                                console.log(res.data)
                         this.tableData = [];
                            let list= res.data.data.beanList[0];
                            this.formItem.subId = list.subId,
                             this.formItem.subName = list.subName,
                             this.formItem.subNature =list.subNature,
                             this.formItem.subNature = list.subNature,
                             this.formItem.subSource = list.subSource,
                             this.formItem.subTeaId =list.subTeaId,
                             this.formItem.subFile =list.subFile,
                             this.formItem.firstReportDeadline =list.firstReportDeadline,
                             this.formItem.lastReportDeadline =list.lastReportDeadline,
                             this.formItem.stuId = list.stuId,
                             this.formItem.subStuState = list.subStuState,
                             this.formItem.subLastScore = list.subLastScore,
                             this.formItem.showId = list.showId,
                             this.formItem.subIntroduce = list.subIntroduce,
                             this.formItem.student = list.student.stuName,
                             this.formItem.teacher = list.teacher.teaName,
                             this.formItem.designShow = list.designShow
                             this.tableData.push({
                               student: this.formItem.student,
                               firstReportDeadline:this.formItem.firstReportDeadline,
                               subStuState:this.formItem.subStuState,
                              yijian:''
                             })
                            })

                        // }).catch(err => {
                        //     console.info('报错的信息',err);
                            
                        // });
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


