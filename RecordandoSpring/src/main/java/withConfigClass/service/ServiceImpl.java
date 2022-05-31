package withConfigClass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import withConfigClass.dependency.Persistence;

@Component
public class ServiceImpl implements Service{

	@Autowired
	private Persistence mySQL;
	
	@Override
	public void doPersist() {
		System.out.println(mySQL.persist());
	}

}
