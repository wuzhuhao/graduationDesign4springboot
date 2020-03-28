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
       let  userId = localStorage.getItem('userId')
         this.$axios({
                            
                            url: 'scoreRecord/list?page=' + 1,
                            method: 'get',//请求的方式
                           
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
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
                              stuName: item.subject.student.stuName
                           })
                          })
                  
                          
                          
                        }).catch(err => {
                            console.info('报错的信息',err);
                            
                        });
      },

    }
}
</script>


