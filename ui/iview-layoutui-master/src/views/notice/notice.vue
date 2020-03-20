<style lang="postcss" scoped>
.home-container{

}
</style>
<template>
    <Column>
        <Row span="11">
            <Card style="width:90%">
                <p slot="title">
                    <Icon type="md-albums"></Icon>
                    学校公告
                </p>
                <a href="#" slot="extra" @click.prevent="showNotice(1)">
                    <Icon type="ios-loop-strong"></Icon>
                    更多
                </a>
                <ul>
                   
                    <li v-for="item in schooleBulletin">
                        
                       <a href="#"  @click.prevent="showNoticeInfo(item.id)"   >{{item.noticeContent}}</a>
                        <a @click.prevent="showNoticeInfo(item.id)" style="width:25%;float:right; ">{{item.noticeTime}}</a>
                    </li>
                   
                </ul>
            </Card>
        </Row>
        <Row span="11"  offset="2"  >
                <Card style="width:90%" >
                    <p slot="title">
                        <Icon type="md-albums"></Icon>
                        学院公告
                    </p>
                    <a href="#" slot="extra" @click.prevent="showNotice(0)">
                        <Icon type="ios-loop-strong"></Icon>
                        更多
                    </a>
                    <ul>
                         <li v-for="item in collegeBulletin">
                        <a @click.prevent="showNoticeInfo(item.id)" target="_blank"  style="width:5%">{{item.noticeContent}}</a>
                        <a @click.prevent="showNoticeInfo(item.id)" style="width:25%;float:right; ">{{item.noticeTime}}</a>
                        
                    </li>
                    </ul>
                </Card>
        </Row>
    </Column>
    
</template>
<script>
import MasterPage from '@/components/Master'
    export default {
        data () {
            return {
                num:0,
                 formItem: {
                id: '',
                noticeTime:  '',
                noticePublisher:  '',
                acaId: '',
                noticeContent:  '',
                academy:  '',
                
        },
                collegeBulletin:{},
                schooleBulletin:{},
                randomMovieList: []
            }
        },
        created(){
             this.getData(1,5);
      },
        methods: {
             
            showNotice (isSchoole) {
             
                  // this.$router.push('/admin')
                                     this.$router.push({
                                        name:'showNotice',
                                         query:{
                                         isSchoole :isSchoole
                                         }
                                        
                                    })
                                  
             
            },
            showNoticeInfo (id) {
                this.$router.push({
                                        name:'noticeInfo',
                                         query:{
                                         id :id
                                         }
                                        
                                    })
            },
        
          getData(page,pageSize){
            
            let params = this.formItem
            let  token = localStorage.getItem('token')
             let  acaId = localStorage.getItem('acaId')
             
              console.log(this.formItem.acaId + '22')
            this.$axios({
                                
                                url: 'notice/list?page=' + page  + '&pageSize=' + pageSize,
                                method: 'get',//请求的方式
                                params:{
                                    acaId:acaId
                                },
                                // token:localStorage.getItem('token')
                            }).then(res => {
                            console.log(res.data)

                            this.collegeBulletin = res.data.data.beanList        
                            }).catch(err => {
                                console.info('报错的信息',err);
                                
                            });

            this.$axios({
                                
                                url: 'notice/list?page=' + page  + '&pageSize=' + pageSize,
                                method: 'get',//请求的方式
                                params:{
                                    acaId:4
                                },
                                // token:localStorage.getItem('token')
                            }).then(res => {
                            console.log(res.data)
                            this.schooleBulletin = res.data.data.beanList        
                            }).catch(err => {
                                console.info('报错的信息',err);
                                
                            });                           
          }
      },
        mounted () {
           
           
        },
      
         components: {
             name
         }
    }
</script>


