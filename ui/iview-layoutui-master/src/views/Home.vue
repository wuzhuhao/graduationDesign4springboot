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
        <div slot="title-toolbar">
            <Button type="primary" icon="md-add" @click="">新增</Button>
        </div>
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="80">
              <Row>
                <Col span="12">
                  <FormItem label="输入框">
                    <Input v-model="formItem.input" placeholder="请输入输入框"></Input>
                </FormItem>
                </Col>
                <Col span="12">
                  <FormItem label="选择框：">
                    <Select v-model="formItem.select">
                        <Option value="beijing">New York</Option>
                        <Option value="shanghai">London</Option>
                        <Option value="shenzhen">Sydney</Option>
                    </Select>
                </FormItem>
                </Col>
              </Row>
              <Row>
                <Col span="12">
                  <FormItem label="日期插件：">
                    <DatePicker type="date" placeholder="请选择日期" v-model="formItem.date" style="width:100%"></DatePicker>
                  </FormItem>                  
                </Col>
                <Col span="12">
                  <FormItem label="时间">
                    <TimePicker type="time" placeholder="请输入时间"></TimePicker>
                  </FormItem>
                </Col>
              </Row>
          </Form>
        </div>
        <div slot="search">
          <Button type="info" icon="ios-search">查询</Button>
        </div>
        <div slot="btns">
          <Button type="primary" icon="md-add">添加</Button>
        </div>
        <div slot="paddingContent">
          <Table :columns="columns1" :data="data1"></Table>
        </div>
        <div slot="pager">
            <Page :total="100" />
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
        formItem1: {
          adminId:'',
          adminPassword:'',
          adminName:'',
          adminSex:'',
          adminAge:'',
          adminBirthday:'',
          adminPhone:'',
          adminMail:'',
          adminAddress:'',
          adminRemarks:'',
          adminType:''
        },
        formItem: {
            input: '',
            select: '',
            radio: 'male',
            checkbox: [],
            switch: true,
            date: '',
            time: '',
            slider: [20, 50],
            textarea: ''
        },
         columns1: [
            {
                title: 'Name',
                key: 'name'
            },
            {
                title: 'Age',
                key: 'age'
            },
            {
                title: 'Address',
                key: 'address'
            }
        ],
        columns1: [
            {
                title: 'Name',
                key: 'name'
            },
            {
                title: 'Age',
                key: 'age'
            },
            {
                title: 'Address',
                key: 'address'
            }
        ],
        data1: [
            {
                name: 'John Brown',
                age: 18,
                address: 'New York No. 1 Lake Park',
                date: '2016-10-03'
            },
            {
                name: 'Jim Green',
                age: 24,
                address: 'London No. 1 Lake Park',
                date: '2016-10-01'
            },
            {
                name: 'Joe Black',
                age: 30,
                address: 'Sydney No. 1 Lake Park',
                date: '2016-10-02'
            },
            {
                name: 'Jon Snow',
                age: 26,
                address: 'Ottawa No. 2 Lake Park',
                date: '2016-10-04'
            }
        ]
      }
    },
     created(){
       this.getParams()
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
      getUser(){
         this.$axios({
                            // headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                            url: 'login',//请求的地址
                            method: 'post',//请求的方式
                            data: this.$Qs.stringify(this.userForm),//请求的表单数据
                        }).then(res => {
                            // this.$store.commit('$_setToken', userInfo.token);
                           
                            })

                        // }).catch(err => {
                        //     console.info('报错的信息',err);
                            
                        // });
      }

    }
}
</script>


