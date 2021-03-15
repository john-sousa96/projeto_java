package br.sp.gov.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sp.gov.cursos.entity.CursosEntity;

public interface CursosRepository extends JpaRepository<CursosEntity, Long> {

}
