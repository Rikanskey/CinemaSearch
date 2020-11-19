export default {
    login: null,
    accessToken: null,
    isAuth() {
        this.load()
        return this.accessToken !== null
    },
    auth(data) {
        localStorage.setItem('user', JSON.stringify(data))
        this.login = data.login
        this.accessToken = data.accessToken
    },
    logout() {
        localStorage.removeItem('user')
        this.login = null
        this.accessToken = null
    },
    load() {
        let data = localStorage.getItem('user')
        if (data !== null && data !== ''){
            data = JSON.parse(data)
            this.login = data.login
            this.accessToken = data.accessToken
        }
    }
}