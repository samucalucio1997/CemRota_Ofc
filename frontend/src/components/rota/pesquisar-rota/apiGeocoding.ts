import axios from "axios"


const api = axios.create({
    baseURL:'http://maps.google.com/maps/api'
  })

export default api;