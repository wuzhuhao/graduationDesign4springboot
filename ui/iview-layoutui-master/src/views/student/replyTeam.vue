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
                    <Input v-model="formItem.stuName"   size="large"    placeholder="请输入答辩组名"></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="答辩地址:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.stuMajor"   size="large"    placeholder="请输入答辩地址"></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="答辩时间:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.stuClass"   size="large"  placeholder="请输入答辩时间"></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="答辩组长:  "  :label-width="200"   class="label">
                    <InputNumber  v-model="formItem.stuAge"   size="large"  style="width:620px"  placeholder="请输入答辩组长"></InputNumber>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="12">
                  <FormItem label="答辩秘书:  "  :label-width="200"  class="label">
                    <InputNumber v-model="formItem.stuPhone"   size="large"  style="width:620px"   placeholder="请输入答辩秘书"></InputNumber>
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
          stuId: '',
          stuPassword: '',
          stuName:  '',
          stuMajor: '',
          stuClass:  '',
          stuSex:  '',
          stuAge: '',
          stuBirthday:  '',
          stuPhone:  '',
          stuMail:  '',
          stuAddress:  '',
          stuRemarks: '',
          academyId:  '',
        
        },
       
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
                            url: 'stu/getStuById',//请求的地址
                            method: 'get',//请求的方式
                            params: {stuId:userId},//请求的表单数据
                        }).then(res => {
                              console.info('报错的信息',res.data);
                               this.formItem.stuId = res.data.data.stuId,
                              this.formItem.stuPassword = res.data.data.stuPassword,
                              this.formItem.stuName = res.data.data.stuName,
                              this.formItem.stuMajor = res.data.data.stuMajor,
                              this.formItem.stuClass = res.data.data.stuClass,
                              this.formItem.stuSex = res.data.data.stuSex,
                              this.formItem.stuAge =res.data.data.stuAge,
                              this.formItem.stuBirthday = res.data.data.stuBirthday,
                              this.formItem.stuPhone = res.data.data.stuPhone,
                              this.formItem.stuMail = res.data.data.stuMail,
                              this.formItem.stuAddress = res.data.data.stuAddress,
                              this.formItem.stuRemarks = res.data.data.stuRemarks,
                              this.formItem.academyId = res.data.data.academyId
                           
                            })

                        // }).catch(err => {
                        //     console.info('报错的信息',err);
                            
                        // });
      },
       update(){
          console.log(this.formItem)
            this.$axios({     
                            url: 'stu/update',
                            method: 'put',//请求的方式
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


