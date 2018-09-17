import Curso
import Estudiante

class Instituto{


    public static void main(String[] a){
        System.out.println("Hola a todos");

         // crear estudiantes
        Estudiante est1 = new Estudiante( 
                                        nombre:"juan",
                                        dni:"345678",
                                        edad: 15,
                                        ciudadNatal:"Catamarca",
                                         nota: 4)
        Estudiante est2 = new Estudiante(
                                        nombre:"Pedro",
                                        dni:"345678",
                                        edad: 14,
                                        ciudadNatal:"Tucuman",
                                         nota: 3)
        Estudiante est3 = new Estudiante(   
                                        nombre:"Martin",
                                        dni:"345678",
                                        edad: 15,
                                        ciudadNatal:"Cordoba",
                                         nota: 10)
        Estudiante est4 = new Estudiante(
                                        nombre:"Juan",
                                        dni:"345678",
                                        edad: 17,
                                        ciudadNatal:"Tucuman",
                                         nota: 6)
        Estudiante est5 = new Estudiante(
                                        nombre:"Maria",
                                        dni:"345678",
                                        edad: 17,
                                        ciudadNatal:"Bs As",
                                         nota: 6)
        Estudiante est6 = new Estudiante(
                                        nombre:"Pepe",
                                        dni:"345678",
                                        edad: 17,
                                        ciudadNatal:"Catamarca",
                                        nota: 10)


        Curso curso = new Curso();

        curso.agregarEstudiante(est1)                                 
        curso.agregarEstudiante(est2)                                 
        curso.agregarEstudiante(est3)                                 
        curso.agregarEstudiante(est4)
        curso.agregarEstudiante(est5)
        curso.agregarEstudiante(est6)

        //Estudiantes que pertenecen al curso
        curso.mostrarEstudiantes() 
        // Estudiantes con nota mayor a 4
        def estudiantesAprob = curso.estudiantesAprobados()
        println estudiantesAprob
        
        // se verifica si exite un terminado estudiante
        boolean isEstudiante =  curso.existeEstudiante(est2)
        println "Existe el estudiante 1 -> " + isEstudiante

        // Se verifica si exite estudiante con nota 10
        boolean isEstudianteDiez =  curso.existeEstudianteConNotaDiez()
        println "Existe alumno con nota 10 -> " + isEstudianteDiez

        // Se verifica si exite estudiante con nombre = "Pedro"
        boolean isEstudianteName = curso.existeEstudianteLlamado("Pedro")
        println "Existe el alumno llamado Pedro -> " + isEstudianteName

        // Se obtiene promedio de aprobados
        float mediaAprobados = curso.porcentajeDeAprobados()
        println "Promedio de aprobados -> " + mediaAprobados +"%"

        float mediaNotas = curso.promedioDeCalificaciones()
        println "Promedio de notas -> " + mediaNotas

        //Estudiantes no catamarqueños 
        def estudiantesNoCat = curso.estudiantesNoCatamarquenios()
        println "Estudiantes no Catamarqueños -> " + estudiantesNoCat

        // Nota mas Frecuente
        int notaMasFrecuente =  curso.calificacionMasFrecuente()
        println "Calificacion mas Frecuente -> " + notaMasFrecuente
       
       // ciudades a la que pertenecen los alumnos excepto catamarca
       def ciudadesExceptoCatamarca = curso.ciudadesExceptoCatamarca()
       println "ciudades (excepto Catamarca) donde nacieron los alumnos inscriptos al curso -> " + ciudadesExceptoCatamarca

       // Retorna verdadero si todos los estudiantes desaprobaron el curso
       println "¿todos los estudiantes desaprobaron el curso? -> " + curso.unDesastre()

       //edades de los estudiantes con la frecuencia en la que aparecen 
       println "edades de los estudiantes con la frecuencia en la que aparecen -> " + curso.frecuenciaDeEdades()
        
    }                                
    

  /*   void mostrarEstudiantes(def estudiantes){
            println "Estudiantes Aprobados -> "
            estudiantes.each { it -> 
                println it.toString() 
        }
    } */
   
}