package local.swasd.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.swasd.api.repository.db.SampleDBRepository;

@Service
public class SampleService {
	@Autowired
	SampleDBRepository sampleRepository;

	public boolean isConnectedDB() {
		try {
			return (sampleRepository.select1() == 1);
		} catch (Exception e) {
			// TODO: logging
			throw e;
		}
	}

}