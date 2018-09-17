import Estudiante

class Curso {
    
    def estudiantes =  [];

    void resetearNotas(){
        estudiantes.each{ estudiante ->
            estudiante.setNota(0)
        }
    }

    void agregarEstudiante(Estudiante estudiante){
        estudiantes << estudiante
    }

    void mostrarEstudiantes(){
        estudiantes.each { estudiante -> 
            println estudiante.toString() 
        }
    }

   def estudiantesAprobados(){
        def estudiantesA = []
        for (estudiante in estudiantes) {
            if(estudiante.getNota() > 4 ){
                estudiantesA << estudiante
            }
        }
        return estudiantesA
    }
    boolean existeEstudiante(Estudiante estudiante){
        boolean isEstudiante =  estudiantes.find{it == estudiante}
    }

    boolean existeEstudianteConNotaDiez(){
        boolean isEstudianteDiez = estudiantes.find { it.getNota() == 10 }
    }

    boolean existeEstudianteLlamado(String nombre){
        boolean isEstudianteName = estudiantes.find { it.getNombre() == nombre}
    }

    float porcentajeDeAprobados(){
        float media = 0
        int totalAprob = 0
        
        estudiantes.each{ it ->
            if(it.getNota() > 4){
                totalAprob++
            }
        }
        media = totalAprob/estudiantes.size()*100
    }

    float promedioDeCalificaciones(){
         float media = 0
        int totalNota = 0
        estudiantes.each {estudiante ->
            totalNota = totalNota + estudiante.getNota()
        }
        media = totalNota/estudiantes.size()
    }

    def estudiantesNoCatamarquenios(){
        def estudiantesNoCat = []
        for (estudiante in estudiantes) {
            if(estudiante.getCiudadNatal() != "Catamarca" ){
                estudiantesNoCat << estudiante
            }
        }
        return estudiantesNoCat
    }

    int calificacionMasFrecuente(){
        int notaMasFrecuente = 0
        int notaMasFrecuenteAux = 0
        int contRepeatNota = 0
        int maxRepeatNota = 0

        def estudiantesOrd = estudiantes.sort{a , b -> 
                            a.getNota() == b.getNota() ? 0 
                            : a.getNota() < b.getNota() ? -1 
                            : 1}

        for (estudiante in estudiantesOrd) {
            if(estudiante.getNota() != notaMasFrecuenteAux){
                contRepeatNota = 1
                notaMasFrecuenteAux =  estudiante.getNota()
               
            }else{
                contRepeatNota++

                if(maxRepeatNota < contRepeatNota){
                    maxRepeatNota = contRepeatNota
                    notaMasFrecuente = notaMasFrecuenteAux
                }
            }
        }

        return notaMasFrecuente
    }

    def ciudadesExceptoCatamarca(){
        def ciudadesExceptoCatamarca = []
        for (estudiante in estudiantes) {
            if(estudiante.getCiudadNatal() != "Catamarca" ){
               ciudadesExceptoCatamarca << estudiante.getCiudadNatal()
            }
        }
        /*  public Collection unique(boolean mutate, Closure closure) ->
            Un método conveniente para hacer que una colección sea única 
            usando un Cierre para determinar elementos duplicados (iguales).
             Si mutate es verdadero, funciona en el objeto receptor y lo devuelve. 
             Si mutate es falso, se devuelve una nueva colección.
         */
        def setCiudadesExceptoCatamarca = ciudadesExceptoCatamarca.unique(false) { a, b -> a <=> b }
    }

    boolean unDesastre(){
        int cont = 0;
        boolean isDesastre = false

        for(estudiante in estudiantes){
            if(estudiante.getNota() <= 4){
                cont++
            }
        }

        if(cont == estudiantes.size()){
            isDesastre = true
        }

        return isDesastre
    }

    def frecuenciaDeEdades(){

        int frecuenciaEdad = 0 
        int edad = 0
        Map map = [:]

         def estudiantesOrd = estudiantes.sort{a , b -> 
                            a.getEdad() == b.getEdad() ? 0 
                            : a.getEdad() < b.getEdad() ? -1 
                            : 1}
        int i
        for (i = 0 ; i< estudiantesOrd.size();) {
         println "ciclo for i = " + i
            if(estudiantesOrd.get(i).getEdad() != edad){
                println "edad distinta"
                edad =  estudiantesOrd.get(i).getEdad()
                while(i < estudiantesOrd.size() && edad == estudiantesOrd.get(i).getEdad()){
                    println "edad -> " + estudiantesOrd.get(i).getEdad()
                    frecuenciaEdad++;
                    i++
                }

            map.put(edad,frecuenciaEdad)              
            frecuenciaEdad = 0 
            }
        }

        return map

    }



}