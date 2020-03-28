<style lang="postcss" scoped>
.label > :first-child{
  font-size: 15px;
  float:center;
}
.home-container{

}
</style>
<template>
<section class="home-container">
    <MasterPage title="公告信息">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem">
           <Row>
                <Col span="24">
                  <FormItem :label="this.formItem.noticeTitlet"   class="label">
                </FormItem>
                </Col>
              </Row>
              
               <Row>
                <Col span="24">
                  <FormItem :label="this.formItem.noticeTime"  class="label">
                </FormItem>
                </Col>
              </Row>
              
             <Row>
               <Col span="24">
               <FormItem :label="this.formItem.noticePublisher"   class="label">
                  
            </FormItem>
             </Col>
              </Row>
              
          </Form>
        </div>
       </div>
        
    </MasterPage>
      <MasterPage>
        
        <div slot="searchContent" class="search-content-slot">
          <br>
          <p style ="font-size: 20px;">
      {{this.formItem.noticeContent}}
          </p>
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
                noticeTime:  '',
                noticePublisher:  '',
                acaId: '',
                noticeContent:  '',
                noticeTitlet:  '',
                academy:  '',
        },
       
       
      }
    },
      mounted () {
           this.getNotice()
        },

     created(){
      
     },
    methods:{
     
      getNotice(){
         let userId = localStorage.getItem("userId") 
         console.log( this.$route.query.id + '123')
         this.formItem.id = this.$route.query.id
         
         this.$axios({
                            // headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                            url: 'notice/list',//请求的地址
                            method: 'get',//请求的方式
                             params: this.formItem,//请求I的数据
                    }).then(res => {
                                console.log(res.data)
                                this.formItem=res.data.data.beanList[0]
                                console.log(this.formItem)
                                 this.formItem.noticeTime = '发布时间： ' + this.formItem.noticeTime 
                                this.formItem.noticePublisher = '发布者： ' + this.formItem.noticePublisher 
                             
                            })
    
 
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


