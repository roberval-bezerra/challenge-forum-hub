-- Criação da tabela `autores`
CREATE TABLE autores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

-- Criação da tabela `cursos`
CREATE TABLE cursos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria ENUM('mobile', 'programação', 'front-end', 'devops', 'ux & design', 'data science', 'inovação & gestão', 'inteligência artificial') NOT NULL
);

-- Criação da tabela `topicos`
CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES autores(id),
    CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

-- Criação da tabela `respostas`
CREATE TABLE respostas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    solucao TEXT,
    topico_id BIGINT NOT NULL,
    data_criacao DATETIME NOT NULL,
    autor_id BIGINT NOT NULL,
    CONSTRAINT fk_topico FOREIGN KEY (topico_id) REFERENCES topicos(id),
    CONSTRAINT fk_autor_resposta FOREIGN KEY (autor_id) REFERENCES autores(id)
);
