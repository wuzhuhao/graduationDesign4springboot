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
                  <FormItem label="真实姓名:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.stuName"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="专业:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.stuMajor"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="班级:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.stuClass"   size="large"  placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="性别:  "  :label-width="200"  class="label">
                     <Select v-model="formItem.stuSex" >
                        <Option value="男" >男</Option>
                        <Option value="女">女</Option>
                    </Select>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="年龄:  "  :label-width="200"   class="label">
                    <InputNumber  v-model="formItem.stuAge"   size="large"  style="width:620px"  placeholder="Enter something..."></InputNumber>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="出生日期："  :label-width="200"   class="label">
                    <DatePicker type="date" placeholder="请选择"   size="large" v-model="formItem.stuBirthday" style="width:100%"></DatePicker>                      
                  </FormItem>  
                </Col>
              </Row>
               <Row>
                <Col span="12">
                  <FormItem label="电话:  "  :label-width="200"  class="label">
                    <InputNumber v-model="formItem.stuPhone"   size="large"  style="width:620px"   placeholder="Enter something..."></InputNumber>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="邮箱:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.stuMail"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="地址:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.stuAddress"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
              <Row>
                <Col span="12">
                  <FormItem label="备注:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.stuRemarks"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="12">
                  <FormItem label="学院:  "  :label-width="200"  class="label">
                     <Select v-model="formItem.stuSex" >
                        <Option value="计算机学院" >计算机学院</Option>
                        <Option value="财务管理学院">财务管理学院</Option>
                    </Select>
                </FormItem>
                </Col>
              </Row>
          </Form>
        </div>
         <div slot="search">
            
          <Button type="info" icon="ios-search"  style="float:left;margin:0 8px;margin-left:4cm" @click="update">修改</Button>  &nbsp; &nbsp; &nbsp; &nbsp;
           <Button type="info" icon="ios-search"  style="float:left;margin:0 8px" @click="doReset">重置</Button>  &nbsp;
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
       this.getUser()
     },
    methods:{
      getParams () {
        // 取到路由带过来的参数 
        var routerParams = this.$route.params.id
        // 将数据放在当前组件的数据内
        this.id = routerParams
      },
      getUser(){
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


