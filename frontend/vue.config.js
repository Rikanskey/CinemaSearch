// vue.config.js

module.exports = {
    // proxy all webpack dev-server requests starting with /api
    // to our Spring Boot backend (localhost:8082) using http-proxy-middleware
    // see https://cli.vuejs.org/config/#devserver-proxy
    // vendor: ['axios', 'http-proxy-middleware'],
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8082', // this configuration needs to correspond to the Spring Boot backends' application.properties server.port
                ws: true,
                changeOrigin: true,
                secure: false
            }
        }
    },
    // Change build paths to make them Maven compatible
    // see https://cli.vuejs.org/config/
    outputDir: 'target/dist',
    assetsDir: 'static'
};