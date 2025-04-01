job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
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
        dockerBuildAndPublish {
            repositoryName('fenixdock/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
