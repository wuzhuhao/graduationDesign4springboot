//  store.js 中都mutation中增加添加和删除token的方法
import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

// const state = {     // 全局管理的数据存储
// 	 isLogin:'0',
// 	 ser:null,
// 	 token:localStorage.getItem('token') ? localStorage.getItem('token'):'',   // token
// };
export default new Vuex.Store({
	state:{
		user: {},
		userName: "",
		menus:[],
		type: '' || localStorage.getItem('type'),
		userId: '' || localStorage.getItem('userId'),
		// 存储token
		token: localStorage.getItem('token') ? localStorage.getItem('token') : '',
		theme1: localStorage.getItem('theme1') ? localStorage.getItem('theme1') : ''
	},

	getters:{    // 监听数据变化的
		getStorage(state){   // 获取本地存储的登录信息
	      if(!state.token){
	        state.token =JSON.parse(localStorage.getItem(key))
	      }
	      return state.token
		},
		type(state) {
			return state.type
			
		},
		userId(state) {
			return state.userId
			
		},
		theme1(state) {
			return state.theme1
			
		}
	},
	setters:{    // 监听数据变化的
		
		
	},
	mutations:{
		token (state, token) {
			state.token = token;
			localStorage.setItem('token', token);
		  },
		type(state, type) {
			state.type = type
			  // 把登录的用户的名保存到localStorage中，防止页面刷新，导致vuex重新启动，用户名就成为初始值（初始值为空）的情况
			localStorage.setItem('type', type)
		  },
		  userId(state, userId) {
			state.userId = userId
			  // 把登录的用户的名保存到localStorage中，防止页面刷新，导致vuex重新启动，用户名就成为初始值（初始值为空）的情况
			localStorage.setItem('userId', userId)
		  },
		  theme1(state, theme1) {
			state.theme1 = theme1
			  // 把登录的用户的名保存到localStorage中，防止页面刷新，导致vuex重新启动，用户名就成为初始值（初始值为空）的情况
			localStorage.setItem('theme1', theme1)
		  },
		orderList(s, d) {
			s.menus= d;
			window.localStorage.setItem("menus",JSON.stringify(s.menus))
		  },
		
		$_setToken(state, value) { // 设置存储token
	        state.token = value;
	        localStorage.setItem('token', value);
	    },
	    $_removeStorage(state, value){  // 删除token
		      localStorage.removeItem('token');
		}
	}
})
