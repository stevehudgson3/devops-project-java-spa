pipeline {
    agent any
    tools {
        jdk 'Default JDK'
        maven 'Default Maven'
    }
    environment {
        // Define any necessary environment variables here
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git branch: 'main', url: 'https://github.com/stevehudgson3/devops-project-java-spa.git'
            }
        }
        stage('Build') {
            steps {
                // Compile the Java application
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Run unit tests
                sh 'mvn test'
            }
        }
        stage('Terraform Init') {
            steps {
                // Initialize Terraform
                dir('terraform/ec2-kubernetes') {
                    sh 'terraform init'
                }
            }
        }
        stage('Terraform Apply') {
            steps {
                // Apply Terraform configurations
                dir('terraform') {
                    sh 'terraform apply -auto-approve'
                }
            }
        }
        stage('Ansible Deploy') {
            steps {
                // Run Ansible playbook
                dir('ansible/ansible-k8s') {
                    sh 'ansible-playbook -i inventory playbook.yml'
                }
            }
        }
    }
    post {
        always {
            // Clean up workspace after build
            cleanWs()
        }
        success {
            // Actions on successful build
            echo 'Build and deployment successful.'
        }
        failure {
            // Actions on failed build
            echo 'Build or deployment failed.'
        }
    }
}
