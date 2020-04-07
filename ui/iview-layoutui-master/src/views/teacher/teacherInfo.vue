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
                    <Input v-model="formItem.teaName"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
              <Row>
                <Col span="12">
                  <FormItem label="性别:  "  :label-width="200"  class="label">
                    <Select v-model="formItem.teaSex" >
                        <Option value="男" >男</Option>
                        <Option value="女">女</Option>
                    </Select>
                </FormItem>
                
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="年龄:  "  :label-width="200"   class="label">
                    <InputNumber  v-model="formItem.teaAge"   size="large"  style="width:620px"  placeholder="Enter something..."></InputNumber>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="出生日期："  :label-width="200"   class="label">
                    <DatePicker type="date" placeholder="请选择"   size="large" v-model="formItem.teaBirthday" style="width:100%"></DatePicker>                      
                  </FormItem>  
                </Col>
              </Row>
               <Row>
                <Col span="12">
                  <FormItem label="电话:  "  :label-width="200"  class="label">
                    <InputNumber v-model="formItem.teaPhone"   size="large"  style="width:620px"   placeholder="Enter something..."></InputNumber>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="邮箱:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.teaMail"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
             <Row>
                <Col span="12">
                  <FormItem label="地址:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.teaAddress"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
              <Row>
                <Col span="12">
                  <FormItem label="备注:  "  :label-width="200"  class="label">
                    <Input v-model="formItem.teaRemarks"   size="large"    placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="12">
                  <FormItem label="学院:  "  :label-width="200"  class="label">
                     <Select v-model="formItem.academyId" >
                        <Option :value="1" >计算机学院</Option>
                        <Option :value="2">财务管理学院</Option>
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
                            url: 'tea/getDetail/' + userId,//请求的地址
                            method: 'get',//请求的方式
                          
                        }).then(res => {
                              console.info(res.data);
                              this.formItem.teaId = res.data.data.teaId,
                              this.formItem.teaPassword = res.data.data.teaPassword,
                              this.formItem.teaName =res.data.data.teaName,
                              this.formItem.teaSex = res.data.data.teaSex,
                              this.formItem.teaAge = res.data.data.teaAge,
                              this.formItem.teaBirthday =res.data.data.teaBirthday,
                              this.formItem.teaPhone =res.data.data.teaPhone,
                              this.formItem.teaMail =res.data.data.teaMail,
                              this.formItem.teaAddress =res.data.data.teaAddress,
                              this.formItem.teaRemarks = res.data.data.teaRemarks,
                              this.formItem.academyId = res.data.data.academyId
                            })

                        // }).catch(err => {
                        //     console.info('报错的信息',err);
                            
                        // });
      },
       update(){
          console.log(this.formItem)
            this.$axios({     
                            url: 'tea/update',
                            method: 'post',//请求的方式
                            data:this.$Qs.stringify(this.formItem),
                            // token:localStorage.getItem('token')
                        }).then(res => {
                        console.log(res.data)
                         this.$Message.success("操作成功");
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                        this.getUser()
                      
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
        this.formItem.academyId = ''
        this.formItem.academy = ''
        this.getUser();
    },
       

    }
}
</script>


