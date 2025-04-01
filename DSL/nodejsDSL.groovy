job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/ftnunez/nodejsapp.git', 'main') { node ->
            node / gitConfigName('ftnunez')
            node / gitConfigEmail('ftnunez@asf.gob.mx')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs14.8.0')
    }
    steps {
        shell("npm install")
    }    
}
