pipelineJob('Demo-Pipeline-Job') {
    description('Created via DSL seed script.')

    definition {
        cps {
            script("""
                node {
                    stage('Set Build Env') {
                        echo 'Setting build environment variables and configurations.'
                    }
                    stage('Clone and Copy Properties') {
                        echo 'Cloning repositories and copying property files.'
                    }
                    stage('Maven Package') {
                        echo 'Packaging with Maven.'
                    }
                    stage('Reporting in Jenkins') {
                        echo 'Reporting test coverage in Jenkins.'
                    }
                    stage('Docker Build') {
                        echo 'Building Docker image.'
                    }
                    stage('Docker Push') {
                        echo 'Pushing Docker image to ECR.'
                    }
                    stage('Helm Deploy') {
                        echo 'Deploying to Kubernetes via Helm.'
                    }
                }
            """.stripIndent())
        }
    }
}

