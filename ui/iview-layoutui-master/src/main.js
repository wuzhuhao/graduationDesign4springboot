import Vue from 'vue'
import App from './App.vue'
import router from './router'
import iView from 'view-design';
import 'iview/dist/styles/iview.css';
import store from './store/store'
import Qs from 'qs'
import '@/styles/icon/iconfont.css'
import VueCookies from 'vue-cookies'
Vue.use(VueCookies)



Vue.prototype.$Qs = Qs
// import PublicFun from './utils/publicFun'    // 公用方法

// import './mintUi'   // 按需引入mintUi 组建   如需配置到mintUi.js去配置
// import '@/assets/mui/css/mui.css' // mui.css样式

/*引入axios插件*/
import axios from 'axios'
Vue.prototype.$axios = axios
Vue.config.productionTip = false


Vue.prototype.$store = store

// 全局路由构造函数，判断是否登录和要跳转到页面
router.beforeEach((to, from, next) => {
  if (to.matched.some(m => m.meta.requireAuth)) {    // 需要登录
    if(window.localStorage.token && window.localStorage.isLogin === '1'){
      next()
    } else if (to.path !== '/login') {
      let token = window.localStorage.token;
      if (token === 'null' || token === '' || token === undefined){
          next({path: '/login'})
          Toast({ message: '检测到您还未登录,请登录后操作！', duration: 1500 })
      }
    } else {
      next()
    }
  } else {   // 不需要登录
    next()
  }
})



// 配置公共url
axios.defaults.baseURL = '/api'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
// axios.defaults.headers.post['Access-Control-Allow-Origin'] = 'http://localhost:8080'
// axios.defaults.headers.post['Access-Control-Allow-Methods'] = 'GET, POST, PATCH, post, DELETE, OPTIONS'
axios.defaults.withCredentials = true; //配置为true
//添加请求拦截器
// axios.interceptors.request.use(
//   config =>{
//     if(store.state.token){
//       config.headers.common['token'] =store.state.token
//     }
//     return config;
//   },
//   error =>{
//     //对请求错误做什么
//     return Promise.reject(error);
//   })

// //http reponse响应拦截器
// axios.interceptors.response.use(
//   response =>{
//     return response;
//   },
//   error=>{
//     if(error.response){
//       switch(error.response.status){
//         case 401:
//           localStorage.removeItem('token');
//           router.replace({
//             path: '/login',
//             query: {redirect: router.currentRoute.fullPath}//登录成功后跳入浏览的当前页面
//           })
//       }
//     }
//   })

// Vue.prototype.$publicFun = PublicFun   // 挂载全局公用方法
// Vue.prototype.$apps = Apps    //  app.js公用方法
Vue.config.productionTip = false
Vue.use(iView);

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')


