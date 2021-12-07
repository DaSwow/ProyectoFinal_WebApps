/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class LoginfrmManager {
   
        constructor(){
            let d = document;
            this.Loginfrm = d.getElementById("Loginfrm");
            this.txtCorreo = d.getElementById("txtCorreo");
            this.txtPsw = d.getElementById("txtPsw");
            this.Loginfrm.onsubmit = this.guardar;
    }
    
        guardar(evt){
            evt.preventDefault();
            let usr = new Object();
            usr.correo = this.txtCorreo.value;
            usr.contrasena = this.txtPsw.value;
            
            //console.log(usr);
            fetch('/ProyectoFinal_WebApps_web/iniciarSesion', {
                headers: { 'Content-type': 'application/json' },
                method: 'POST',
                body: JSON.stringify(usr)
            }).then((data) => {
                alert('Sesión iniciada');
                //console.log(data);
            })
            .catch((err)=>{
                alert("Error al iniciar sesión");
            });
    }
    }