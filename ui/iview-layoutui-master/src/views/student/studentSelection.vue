<style lang="postcss" scoped>
.home-container{

}
</style>
<template>
<section class="home-container">
    <MasterPage title="学生选题">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        
        <div slot="paddingContent">
          <Table :columns="columns1"  stripe   border  :data="tableData"></Table>
        </div>
       
    </MasterPage>
 <Modal v-model="modal11"   closable  :styles="{top: '10px'}":width='1000' >
        <info></info>
    </Modal>
</section>
</template>
<script>
import MasterPage from '@/components/Master'
import info from './studentSelectionInfo'

export default {
    components:{
        MasterPage,
        info

    },
    data(){
      return{
        modal11: false,
        showInfo:false,
         pagination: {
                pageSize:10,
                page: 1,
                total:0,
                pageSizeOpts:[5, 10, 15, 20,25,30],
                currentPage:1
        },
        tableData:[],
        id:'',
        teacher:  {
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
                
        formItem: {
          subId: '',
          subName: '',
          subNature: '',
          subSource: '',
          subTeaId: '',
          subFile:'',
          firstReportDeadline: '',
          lastReportDeadline:'',
          stuId:'',
          subStuState: '',
          subLastScore:'',
          showId:'',
          subIntroduce: '',
          student:'',
          teacher: '',     
          designShow: '',
        },
       
        columns1: [
          {
              title: '序号',
              type: 'index',
              width: 150,
              align: 'center'
            },         
            {
                title: '课题名称',
                key: 'subName',
                width: 400,
                minWidth: 100,
            },
            {
                title: '课题来源',
                key: 'subNature',
                minWidth: 150,
            },
            {
                title: '指导老师',
                key: 'teaName',
                minWidth: 150,
            },
            {
                title: '选题状态',
                key: 'subStuState',
                minWidth: 150,
            },
            {
                        title: '操作',
                        key: 'action',
                        fixed: 'right',
                         width: 200,
                        minWidth: 150,
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small',
                                    
                                    },
                                     attrs:{
                                        title:'编辑'
                                    },
                                      on: {
                                        click: () => {
                                        this.select(params.row)             //编辑方法
                                        }
                                      }
                                } ,'查看')
                            ]);
                        }
                    }
        ],
       
      }
    },
     created(){
       this.getSubject()
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
      select(row){
       this.modal11 = true;
      },
      getSubject(){
         let userId = localStorage.getItem("userId") 
         this.$axios({
                            // headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                            url: 'sub/listOfChoice',//请求的地址
                            method: 'get',//请求的方式
                            params: {stuId:userId},//请求的数据
                        }).then(res => {
                                console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList;
                          list.forEach((item, index) => {
                           this.tableData.push({
                              subId: item.subId,
                              subName: item.subName,
                              subNature:item.subNature,
                              subNature: item.subNature,
                              subSource: item.subSource,
                              subTeaId:item.subTeaId,
                              subFile:item.subFile,
                              teafirstReportDeadlineMail:item.firstReportDeadline,
                              lastReportDeadline:item.lastReportDeadline,
                              stuId: item.stuId,
                              subStuState: item.subStuState,
                              subLastScore: item.subLastScore,
                              showId: item.showId,
                              subIntroduce: item.subIntroduce,
                              teaName:item.teacher.teaName,
                              academyId: item.teacher.academyId,
                              designShow: item.designShow,                             
                           })
                          })
                  
                           this.pagination.total =res.data.data.totalRecord
                           this.pagination.currentPage =res.data.data.currentPage
                          
                           
                            })

                        // }).catch(err => {
                        //     console.info('报错的信息',err);
                            
                        // });
      },
      pageChange(page){
          this.getData(page,this.pagination.pageSize)
      },
      pageSizeChange(pageSize){
          this.getData(this.pagination.page,pageSize)
      },

    }
}
</script>


