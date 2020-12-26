import api from '../../views/backend-api'

export default {
    login: null,
    accessToken: null,
    id: 0,
    isAuth() {
        this.accessToken = localStorage.getItem('access-token')
        return this.accessToken !== null
    },
    logout() {
        localStorage.removeItem('access-token')
        localStorage.removeItem('username')
        this.id = 0
    },
    loadCurrentUser() {
        let data = localStorage.getItem('username')
        console.log(data)
        if (data !== null && data !== '') {
            api.getUserIdByUsername(data).then(response => {
                console.log(response)
                this.id = response.data
            })
        }
    }
}