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
        <div slot="search">
            
        <Upload action="http://localhost:8080/uploadFile/importReplyScoreByExcel"    style="float:left;margin:0 8px">
            <Button  type="info" icon="ios-cloud-upload-outline">批量录入答辩成绩</Button>
        </Upload>
         <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataDemo()"><Icon type="ios-download-outline"></Icon>导出成绩模板</Button>&nbsp;
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
      
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="100">
           <Row>
                <Col span="24">
                  <FormItem label="答辩成绩:  "   class="label">
                    <Input v-model="formItem.replyScore"   size="large"  placeholder="请输入初稿成绩"></Input>
                </FormItem>
                </Col>
              </Row>
              
               <Row>
               
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
                key: ' subLasScore',
                minWidth: 100,
            } ,{
                        title: '操作',
                        key: 'action',
                        width: 120,
                         minWidth: 120,
                        render: (h, params) => {
                            return h('div', [
                              
                                 h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small',
                                        // icon: "icon iconfont icon-shanchu"
                                    }, 
                                     attrs:{
                                        title:'答辩成绩录入'
                                    },
                                      on: {
                                        click: () => {
                                        this.updateScore(params.row)             //编辑方法
                                        }
                                      }
                                },'答辩成绩录入'),
                              
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
        exportDataDemo(type){
       
            window.location.href="http://localhost:8080/downFile/exportScore" 
        
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
                              subName: item.subject.subName,
                              subLastScore: item.subject.subLastScore,
                              stuName: item.subject.student.stuName,
                              subLasScore:item.subject.student.subLasScore,
                           })
                          })
                  
                          
                          
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
      },

    }
}
</script>


