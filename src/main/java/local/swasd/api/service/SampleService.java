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
			if (sampleRepository.select1() == 1) {
				return true;
			}
		} catch (Exception e) {
			// TODO: logging
			return false;
		}

		return false;
	}

}