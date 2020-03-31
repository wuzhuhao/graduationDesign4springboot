<style lang="postcss" scoped>
.label > :first-child{
  font-size: 16px;
  
}
.home-container{

}
</style>
<template>
<section class="home-container">
    <MasterPage title="个人信息">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="80">
             <Row>
                <Col span="12">
                  <FormItem label="答辩组名:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.teamName"   size="large"    placeholder="请输入答辩组名"></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="答辩地址:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.teamAddress"   size="large"    placeholder="请输入答辩地址"></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="答辩时间:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.replyTime"   size="large"  placeholder="请输入答辩时间"></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="答辩组长:  "  :label-width="200"   class="label">
                    <Input v-model="teaName"   size="large"  placeholder="请输入答辩时间"></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="12">
                  <FormItem label="答辩秘书:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.teamLeaderId"   size="large"  placeholder="请输入答辩时间"></Input>
                </FormItem>
                </Col>
              </Row>
          </Form>
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
        id:'',
        formItem: {
         id: '',
          replyTime: '',
          teacher: '',
          teamAddress:  '',
          teamLeaderId:  '',
          teamName:  '',
                  
        },
        teaName:'',
       
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
      getData(){
        let userId = localStorage.getItem("userId") 
         this.$axios({
                            url: 'teamTeaRelate/list?isJoinReplyTeam=true&isJoinScoreRecord=true&isJoinSubject=true',//请求的地址
                            method: 'get',//请求的方式
                              params: {stuId:userId},//请求的表单数据
                        }).then(res => {
                             console.info( res.data.data);
                               this.formItem= res.data.data.beanList[0].replyTeam
                               this.teaName =  res.data.data.beanList[0].teacher.teaName
                             console.info(this.teaName);
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


