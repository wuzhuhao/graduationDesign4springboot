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
          <Table border  show-summary :columns="columns2" :data="data1"  @on-selection-change="changeSelect" ref="table"></Table>
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
         columns2: [
            {
               type: 'selection',
               width: 60,
               align: 'center',
              fixed: 'left'
             },
            
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
                key: 'teaSex',
                minWidth: 100,
            },
            {
                title: '终稿成绩',
                key: 'teaAge',
                minWidth: 100,
            },
            {
                title: '答辩成绩',
                key: 'teaBirthday',
                minWidth: 100,
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
     getData(){
        let params = this.formItem
       let  token = localStorage.getItem('token')
         this.$axios({
                            
                            url: 'scoreRecord/list?page=' + 1 ,
                            method: 'get',//请求的方式
                           
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                           this.tableData.push({
                              teaId: item.teaId,
                              teaPassword: item.teaPassword,
                              teaName:item.teaName,
                              teaSex: item.teaSex,
                              teaAge: item.teaAge,
                              teaBirthday:item.teaBirthday,
                              teaPhone:item.teaPhone,
                              teaMail:item.teaMail,
                              teaAddress:item.teaAddress,
                              teaRemarks: item.teaRemarks,
                              academyId: item.academyId,
                           })
                          })
                  
                          
                          
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
      },

    }
}
</script>


