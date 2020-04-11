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
       
        <div slot="paddingContent">
          <Table border  :columns="columns2" :data="tableData"   ref="table"></Table>
        </div>
       
    </MasterPage>
    <Modal v-model="modal11"   closable @on-ok='update' :styles="{top: '30%'}":width='700' >
       <MasterPage >
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
                  <FormItem label="初稿成绩:  "   class="label">
                    <Input v-model="formItem.firstReportScore"   size="large"  placeholder="请输入初稿成绩"></Input>
                </FormItem>
                </Col>
              </Row>
              
               <Row>
                <Col span="24">
                  <FormItem label="终稿成绩:  "   class="label">
                    <Input v-model="formItem.finalReportScore"   size="large"  placeholder="请输入初稿成绩"></Input>
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
        modal11:false,
        id:'',
      
        formItem: {
          id:'',
          firstReportScore:'',
           finalReportScore:''
        },
        tableData:[],
         columns2: [
            
            {
                type: 'index',
                 title: '序号',
                width: 100,
                fixed: 'left',
                sortable: true
            },
            {
                title: '所属课题',
                key: 'subName',
                minWidth: 100,
            },
            {
                title: '学生',
                key: 'stuName',
                minWidth: 100,
            }, {
                title: '初稿成绩',
                key: 'firstReportScore',
                minWidth: 100,
            },
            {
                title: '终稿成绩',
                key: 'finalReportScore',
                minWidth: 100,
            },
            {
                title: '答辩成绩',
                key: 'replyScore',
                minWidth: 100,
            } ,
            {
                title: '总成绩',
                key: 'subLastScore',
                minWidth: 100,
            } ,{
                        title: '操作',
                        key: 'action',
                        width: 200,
                         minWidth: 200,
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small',
                                        // icon: "icon iconfont icon-shanchu"
                                    },  style: {
                                        marginRight: '5px'
                                        },
                                     attrs:{
                                        title:'最终评定'
                                    },
                                      on: {
                                        click: () => {
                                        this.confirmScore(params.row.subId)             //编辑方法
                                        }
                                      }
                                },'最终评定'),
                                 h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small',
                                        // icon: "icon iconfont icon-shanchu"
                                    }, 
                                     attrs:{
                                        title:'成绩录入'
                                    },
                                      on: {
                                        click: () => {
                                        this.updateScore(params.row)             //编辑方法
                                        }
                                      }
                                },'成绩录入'),
                              
                            ]);
                        }
                    }
        ],
       
        data1: [
           
        ]
      }
    },
     created(){
       this.getData()
     },
    methods:{
      getParams () {
        // 取到路由带过来的参数 
        var routerParams = this.$route.params.id
        // 将数据放在当前组件的数据内
        this.id = routerParams
      },
      // watch: {
      //   // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
      //     '$route': 'getParams'
      // },
      updateScore(row){
      
          this.formItem.id = row.id
          // this.formItem.firstReportScore = row.firstReportScore
          // this.formItem.finalReportScore = row.finalReportScore
          this.modal11 = true;
   
      },
      update(){
       
       
             this.$axios({     
                            url: 'scoreRecord/update',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify(this.formItem),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                        this.getData()
                        this.modal11 = false
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                            
                        });
                        
        
   
      },
      confirmScore(subId){
         this.$axios({
                            
                            url: 'sub/confirmScore?subId=' + subId ,
                            method: 'get',//请求的方式
                           
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          
                            this.$Message.success(res.data.data)
                            this.getData()
                          
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
      },
     getData(){
        let params = this.formItem
       let  userId = localStorage.getItem('userId')
         this.$axios({
                            
                            url: 'scoreRecord/list?page=' + 1 ,
                            method: 'get',//请求的方式
                           
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                           
                            if(item.replyScore==-1){
                              item.replyScore=''
                            }
                           this.tableData.push({
                              finalReportScore: item.finalReportScore,
                              firstReportScore:item.firstReportScore,
                              id: item.id,
                              replyScore: item.replyScore,
                              replyTeam: item.replyTeam,
                              replyTeamId: item.replyTeamId,
                              scoreSubId:item.scoreSubId,
                              subId:item.subject.subId,
                              subName: item.subject.subName,
                              subLastScore: item.subject.subLastScore,
                              stuName: item.subject.student.stuName,
                             
                           })
                       
                          })
                  
                          
                          
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
      },

    }
}
</script>


