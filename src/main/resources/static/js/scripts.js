new Vue({
    el: '#app',
    data: {
        image: null,
        yesterday_rate: null,
        yesterday_date: null,
        latest_rate: null,
        latest_date: null,
    },
    mounted() {
        axios.get('/gif_controller')
        .then(response => {
            this.image = response.data
        })
        .catch(error => {
            console.log(error.message)
        }),
        axios.get('/rate/yesterday')
        .then(response => {
            this.yesterday_rate = response.data.rate
            this.yesterday_date = response.data.date
        })
        .catch(error => {
            console.log(error.message)
        }),
        axios.get('/rate/latest')
        .then(response => {
            this.latest_rate = response.data.rate
            this.latest_date = response.data.date
        })
        .catch(error => {
            console.log(error.message)
        })
    }
})