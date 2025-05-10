package klu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;

import klu.repository.JobsRepository;

@Service
public class JobsManager {
@Autowired
JobsRepository JR;
public String createJob(Jobs J)
  {
    try
    {
     JR.save(J);
      return "200::Your Appointment is Added";
    }catch(Exception e)
    {
      return "400::" + e.getMessage();
    }
  }
public String readJobs() {
	try {
		List<Jobs> jobsList=JR.findAll();
		return new GsonBuilder().create().toJson(jobsList);
		
	}
	catch(Exception e) {
		return "400: :" + e.getMessage();
	}

}
public String getData(Long id)
{
  try
  {
    Jobs J = JR.findById(id).get();
    return new GsonBuilder().create().toJson(J);
  }catch(Exception e)
  {
    return "404::"+e.getMessage();
  }
}
public String updateJob(Jobs J) {
	try {
		JR.save(J);
		return "200::Your Appointment is Updated";
	}catch(Exception e){
		return "400::"+e.getMessage();
	}
}
public String deleteJob(Long id)
{
  try
  {
    JR.deleteById(id);
    return "200::Appointment  has been deleted";
  }catch(Exception e)
  {
    return "404::" + e.getMessage();
  }
}

}
