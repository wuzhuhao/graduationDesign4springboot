module.exports = {
    baseUrl: 'iview-layoutui',
	 devServer: {
        // 设置主机地址
        host: 'localhost',
        // 设置默认端口
        port: 8081,
        // 设置代理
    
	 proxy: {//配置跨域
            '/api': {
                target: 'http://localhost:8080/graManagement/',//这里后台的地址模拟的;应该填写你们真实的后台接口
                ws: true,
                changOrigin: true,//允许跨域
                pathRewrite: {
                    '^/api': ''//请求的时候使用这个api就可以
                }
            }
            
        }

	


	}
}