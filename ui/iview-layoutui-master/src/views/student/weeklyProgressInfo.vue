<style lang="postcss" scoped>
.label > :first-child{
  font-size: 15px;
}
.home-container{

}
</style>
<template>
<section class="home-container">
    <MasterPage title="课题信息">
        <div slot="title-icon">
            <Icon type="ios-game-controller-b" />
        </div>
        <div slot="title-toolbar">
            <Button type="info"  style="float:left;margin:0 8px"  @click="exportDataDemo(2)"><Icon type="ios-download-outline"></Icon>导出模板</Button>&nbsp;
        </div>
        
        <div slot="searchContent" class="search-content-slot">
            <Form :model="formItem" :label-width="100">
           <Row>
                <Col span="24">
                  <FormItem label="课题名称:  "   class="label">
                    <Input v-model="formItem.subName" readonly  size="large"  placeholder="请输入课题名称"></Input>
                </FormItem>
                </Col>
              </Row>
              
               <Row>
                <Col span="24">
                  <FormItem label="指导教师:  "   class="label">
                    <Input v-model="formItem.teaName"  readonly size="large"  placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
               <Row>
                <Col span="24">
                  <FormItem label="内容指导:  "   class="label">
                    <Input v-model="formItem.zhidao"  readonly size="large"  placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
              
             <Row>
                <Col span="24">
                  <FormItem label="指导内容:  "    class="label">
                    <Input v-model="formItem.progContent" readonly type="textarea" :autosize="{minRows: 10,maxRows: 20}" size="large"  placeholder="Enter something..."></Input>
                </FormItem>
                </Col>
              </Row>
          </Form>
        </div>
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
         tableData:[],
        id:'',
       formItem: {
           id: '',
            progContent: '',
            progContentTime: '',
            progReply: '',
            progReplyTime: '',
            progressSubId: '',
            subName:'',
            teaName:'',
            zhidao:'面授'
        },
        
       
      }
    },
     created(){
       this.getData(1,10);
     },
    methods:{
      getData(page,pageSize){  
         this.formItem.id= localStorage.getItem('weeklyProgressId')
        let params = this.formItem
       let  token = localStorage.getItem('token')
         this.$axios({
                            
                           url: 'progress/list',
                            method: 'get',//请求的方式
                            params:params,
                            // token:localStorage.getItem('token')
                        }).then(res => {
                          console.log(res.data)
                         this.tableData = [];
                          let list = res.data.data.beanList[0]; 
                            this.formItem.id = list.id,
                            this.formItem.progContent =list.progContent,
                            this.formItem.progContentTime = list.progContentTime,
                            this.formItem.progReply = list.progReply,
                            this.formItem.progReplyTime =  list.progReplyTime,
                            this.formItem.progressSubId = list.progressSubId,
                            this.formItem.subName = list.subject.subName,
                            this.formItem.teaName = list.subject.teacher.teaName
                          
                        })
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


