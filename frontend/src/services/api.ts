import axios from "axios"
import { removeToken, SERVICE } from "./auth"


class Api {
  public axios

  constructor(serviceUrl: string = SERVICE.CORE) {
    this.axios = axios.create({
      baseURL: serviceUrl,
      headers: {
        'Content-Type': 'application/json',
        Accept: '*/*',
      },
    })
    
    this.axios.interceptors.response.use(
      (response: any) => response,
      async (error) => {
        if (error.response.status === 401) {
            //refreshtoken
            removeToken()
            return Promise.reject() 
        }
        else if ((error.response.status === 403)) {
            //mandar pro login
            removeToken()
          return Promise.reject()
        }
      }
    )
  }
}

export { Api, SERVICE }