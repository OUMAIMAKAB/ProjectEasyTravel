package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ensak.tourismeApp.beans.Post;
import com.ensak.tourismeApp.beans.Utilisateur;
import com.ensak.tourismeApp.dao.IBanqueDao;
import com.ensak.tourismeApp.dao.IPostDao;
import com.ensak.tourismeApp.dao.IUtilisateurDao;
import com.ensak.tourismeApp.service.IPostService;
@Transactional
public class PostServiceImpl implements IPostService{
	
	@Autowired
	private IPostDao dao;
	
	public void setDao(IPostDao dao) {
		this.dao = dao;
	}
@Override
public Post save(Post entity) {
	
	return dao.save(entity);
}

@Override
public Post update(Post entity) {
	
	return dao.update(entity);
}

@Override
public List<Post> selectAll() {
	
	return dao.selectAll();
}

@Override
public List<Post> selectAll(String sortField, String sort) {
	
	return dao.selectAll(sortField, sort);
}

@Override
public Post getById(int id) {
	
	return dao.getById(id);
}

@Override
public void remove(int id) {
	dao.remove(id);
	
}

@Override
public Post findOne(String paramName, Object paramValue) {
	
	return dao.findOne(paramName, paramValue);
}

@Override
public Post findOne(String[] paramNames, Object[] paramValues) {

	return dao.findOne(paramNames, paramValues);
}

@Override
public int findCountBy(String paramName, String paramValue) {
	
	return dao.findCountBy(paramName, paramValue);
}
@Override
public List<Post> getUtilisateurPost(int idUtilisateur) {
	return dao.getUtilisateurPost(idUtilisateur);
}
@Override
public Post getByIdAndIdUtilisateur(int id, int idUtilisateur) {
	return dao.getByIdAndIdUtilisateur(id, idUtilisateur);
}
//public void insertByIdUtilisateur(int id, String texte, int idUtilisateur) {
	
//}

}





