

<style lang="postcss" scoped>
.login-container{
    display:flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: calc(100%);
    & .bg-wrap{
        width: 100%;
        height: 100%;
        background-size: cover;
        background-position: center;
        position: relative;
    }
    & .card-wrap{
        position: absolute;
        right:100px;
        top:200px;
    }
    & .icon-cls{
        font-weight:bold;
        width:20px;
        font-size:18px;
    }
}
</style>
<template>
<section class="login-container">
    <div class="bg-wrap" :style="{backgroundImage:`url(${login_img})`}">
        <div class="card-wrap">
        <Card style="width:350px" :dis-hover="true">
            <p slot="title">
                <Icon type="log-in"></Icon>
                欢迎登录
            </p>
            <Form ref="userForm" :model="userForm" :rules="ruleCustom">
                <FormItem prop="number">
                    <Input v-model.trim="userForm.number" placeholder="请输入" size="large">
                        <Icon type="ios-person-outline" slot="prepend" class="icon-cls"></Icon>
                    </Input>
                </FormItem>
                <FormItem prop="password">
                    <Input type="password" v-model.trim="userForm.password" placeholder="请输入密码" size="large">
                        <Icon type="ios-lock-outline" slot="prepend"  class="icon-cls"></Icon>
                    </Input>
                </FormItem>
                <FormItem prop="type">
                    <RadioGroup v-model="userForm.type" number >
                        <Radio label=1 border></Radio>
                        <Radio label=2 border></Radio>
                        <Radio label=3 border></Radio>
                    </RadioGroup>
                 </FormItem>
                <FormItem>
                    <Button type="primary" @click="handleSubmit('userForm')" long :loading="login_loading">登录</Button>
                </FormItem>
            </Form>
        </Card>
    </div>
    </div>
</section>
</template>
<script>

export default {
    data(){
        return {
            login_loading:false,
            login_img:require("@/assets/login-bg.jpg"),
            userForm:{
                number:'',
                password:'',
                type:''
            },
            ruleCustom: {
                username: [
                    { required: true, message: '用户名不能为空', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '密码不能为空', trigger: 'blur' }
                ]
            }
        }
    },
    methods:{
        btn_login(){
            this.$router.push('/login')
        },
   
      loginAction(userForm) {
        this.$axios.post('http://localhost:18256/graManagement/login', {
          number: 'admin',
          password: '1231231',
          type:'3'
        })
          .then(function(response){
               console.log(this); //这里 this = undefined
          })
          .catch((error)=> {
              console.log(this); //箭头函数"=>"使this指向vue
          });

        },
      

    handleSubmit(name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$axios({
                            // headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                            url: 'login',//请求的地址
                            method: 'post',//请求的方式
                            data: this.$Qs.stringify(this.userForm),//请求的表单数据
                        }).then(res => {
                            // this.$store.commit('$_setToken', userInfo.token);
                            console.log(res.data.message)
                            if(res.data.message=='success'){
                                if(this.userForm.type==3){
                                    this.$router.push('/admin')
                                    
                                }else  if(this.userForm.type==2){
                                    this.$router.push('/home')
                                }else if(this.userForm.type==1){

                                    this.$router.push({
                                        path:'/home',
                                        name:'home',
                                        params:{
                                        id : res.data.adminId
                                        }
                                    })
                                }else{       
                                        this.$Message.info({
                                            content: '未选择身份',
                                            duration: 10,
                                            closable: true
                                        });     
                                }
                            }else{       
                                        this.$Message.info({
                                            content: res.data.message,
                                            duration: 5,
                                            closable: true
                                        });     
                                }
                        

                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
                    } else {
                        console.info(this.$Message.error('表单校验失败!'));
                        
                    }
                })
    }
    },
}
</script>

