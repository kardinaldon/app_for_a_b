new Vue({
    el: '#app',
    data: {
        image: null
    },
    mounted() {
        axios.get('/gif_controller')
        .then(response => {
            this.image = response.data
        })
        .catch(error => {
            this.advice = 'There was an error: ' + error.message
        })
    }
})