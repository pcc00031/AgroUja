/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//js/app-noticia.module.js ES6

class NoticiaController{
    constructor($http){
        //Dependencies injection
        this.noticias = [];
        this.$http = $http;
        this.serviceUrl='api/noticia';
        this.cargaNoticias();
        this.formVisibility=false;
    }
    
    altaNoticias(){
        this.$http.post(this.serviceUrl, this.noticia)
                .then(response => {
                    console.log("Noticia enviada");
                    this.noticia={};
                    this.errorMsgs=[];
                }).then( () => this.cargaNoticias()
                ).catch(response => { //bean validation errors
                    this.errorMsgs = response.data;
                });   
    }
    
    cargaNoticias(){
        this.$http({  //= this.$http.get(this.serviceUrl).then(...);
            method: 'GET',
            url:this.serviceUrl
        }).then(response => {
            this.noticias=response.data;
        });
    }
    
    borrar(asunto){
        this.$http.delete(this.serviceUrl + "/" + asunto);
        this.cargaNoticias();
    }
    
    showForm(){
        this.formVisibility=!this.formVisibility;
    }
}

NoticiaController.$inject = ['$http'];

const appNoticiaComponent = {
    templateUrl:'./js/app-noticia.template.html',
    controller: NoticiaController
};

export const AppNoticiaModule = angular
        .module ("noticia.app",[]) //nombre del modulo
        .component("appNoticia", appNoticiaComponent) //id=appNoticia, objeto JS = appNoticiaComponent
        .name; 



